package es.travelworld.travelling.view;

import static es.travelworld.travelling.Constants.KEY_PASSWORD;
import static es.travelworld.travelling.Constants.KEY_USER;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

import es.travelworld.travelling.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private NavController homeNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initNavigation();
        userWelcome();
    }

    private void initNavigation() {
        NavHostFragment homeNavHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(binding.navHostMain.getId());
        if (homeNavHostFragment != null) {
            homeNavController = homeNavHostFragment.getNavController();
        }
    }

    private void userWelcome() {
        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString(KEY_USER);
            String password = getIntent().getExtras().getString(KEY_PASSWORD);
            Snackbar.make(binding.homeContainer, "Bienvenido " + name + " " + password, Snackbar.LENGTH_SHORT).show();
        }
    }
}