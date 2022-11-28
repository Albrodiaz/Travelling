package es.travelworld.travelling.view;

import static es.travelworld.travelling.Constants.KEY_PASSWORD;
import static es.travelworld.travelling.Constants.KEY_USER;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private final String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        checkLocationPermission();
    }

    private void checkLocationPermission() {
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                    Boolean fineLocationGranted = result.getOrDefault(permissions[1], false);
                    Boolean coarseLocationGranted = result.getOrDefault(permissions[0], false);
                    if (fineLocationGranted != null && !fineLocationGranted || coarseLocationGranted != null && !coarseLocationGranted) {
                        showPermissionInfo();
                    } else {
                        userWelcome();
                    }
                });
        locationPermissionRequest.launch(permissions);
    }

    private void userWelcome() {
        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString(KEY_USER);
            String password = getIntent().getExtras().getString(KEY_PASSWORD);
            Snackbar.make(binding.homeContainer, "Bienvenido " + name + " " + password, Snackbar.LENGTH_SHORT).show();
        }
    }

    private void showPermissionInfo() {
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
        alertDialogBuilder
                .setTitle(R.string.requiredPermission)
                .setMessage(R.string.permissionDescription)
                .setCancelable(false)
                .setPositiveButton(R.string.understood,
                        (dialog, which) -> {
                            dialog.cancel();
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            finish();
                        })
                .show();
    }
}