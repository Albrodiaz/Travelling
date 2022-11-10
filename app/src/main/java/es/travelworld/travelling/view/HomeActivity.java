package es.travelworld.travelling.view;

import static es.travelworld.travelling.Constants.EURODISNEYWEB;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.ActivityHomeBinding;
import es.travelworld.travelling.view.fragments.loginFragments.CarFragment;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    Fragment carFragment = new CarFragment();
    String name, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
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
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, carFragment).commit();
                    return true;
                default:
                    Toast.makeText(getApplicationContext(), "Algo ha fallado", Toast.LENGTH_SHORT).show();
            }
            return HomeActivity.super.onOptionsItemSelected(item);
        });
    }

    @Override
    public void onBackPressed() {
        //Anular botón atrás
    }
}