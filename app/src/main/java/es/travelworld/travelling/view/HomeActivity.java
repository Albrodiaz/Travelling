package es.travelworld.travelling.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

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
    }

    private void initNavigation() {
        NavHostFragment homeNavHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(binding.navHostMain.getId());
        homeNavController = homeNavHostFragment.getNavController();
    }
}