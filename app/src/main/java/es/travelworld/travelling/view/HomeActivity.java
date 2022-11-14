package es.travelworld.travelling.view;

import static es.travelworld.travelling.Constants.EURODISNEYWEB;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.ActivityHomeBinding;
import es.travelworld.travelling.view.fragments.homeFragments.HomePageAdapter;
import es.travelworld.travelling.view.fragments.loginFragments.CarFragment;
import es.travelworld.travelling.view.viewmodels.LoginViewModel;

public class HomeActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    ActivityHomeBinding binding;
    String name, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        setContentView(view);
        configToolbar();
        setAdapter();
        getUserData(view);
        listeners();
    }

    private void getUserData(View v) {
        if (getIntent().getExtras() != null) {
            name = getIntent().getStringExtra("UserName");
            surname = getIntent().getStringExtra("UserSurname");
            Snackbar.make(v, getString(R.string.welcome_home, name, surname), Snackbar.LENGTH_SHORT).show();
        }
    }

    private void listeners() {
        binding.homeToolbar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.iconCastle:
                    Uri web = Uri.parse(EURODISNEYWEB);
                    startActivity(new Intent(Intent.ACTION_VIEW, web));
                    return true;
                case R.id.itemCar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, CarFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                    return true;
                default:
                    Toast.makeText(getApplicationContext(), "Algo ha fallado", Toast.LENGTH_SHORT).show();
            }
            return HomeActivity.super.onOptionsItemSelected(item);
        });
    }

    private void setAdapter() {
        HomePageAdapter pageAdapter = new HomePageAdapter(this);
        binding.homeViewPager.setAdapter(pageAdapter);
        binding.homeViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        new TabLayoutMediator(binding.homeTabLayout, binding.homeViewPager, ((tab, position) -> {
            if (position == 0) {
                tab.setIcon(R.drawable.ic_baseline_camera_alt_24);
            }
            if (position == 1) {
                tab.setIcon(R.drawable.baseline_directions_car_filled_white_24dp);
            }
            if (position == 2) {
                tab.setIcon(R.drawable.ic_mountain_24);
            }
            if (position == 3) {
                tab.setIcon(R.drawable.baseline_face_black_24dp);
            }
        })).attach();
    }

    private void configToolbar() {
        loginViewModel.getFragmentSelected().observe(this, fragment -> {
            if (Objects.equals(fragment.getTag(), "f0")) {
                binding.homeToolbar.setTitle(R.string.home);
                binding.homeToolbar.inflateMenu(R.menu.home_menu);
            } else {
                binding.homeToolbar.setTitle(R.string.vehicle_title);
                binding.homeToolbar.getMenu().clear();
            }
        });
    }
}