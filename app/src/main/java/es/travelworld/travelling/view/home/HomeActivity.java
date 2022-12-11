package es.travelworld.travelling.view.home;

import static es.travelworld.travelling.utilities.Constants.CHANNEL_ID;
import static es.travelworld.travelling.utilities.Constants.COARSE_LOCATION;
import static es.travelworld.travelling.utilities.Constants.FINE_LOCATION;
import static es.travelworld.travelling.utilities.Constants.KEY_PASSWORD;
import static es.travelworld.travelling.utilities.Constants.KEY_USER;
import static es.travelworld.travelling.utilities.Constants.NOTIFICATION_ID;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private final String[] permissions = new String[]{FINE_LOCATION, COARSE_LOCATION};
    private String name, password;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannel();
        checkUserData();
        checkLocationPermission();
    }

    private void checkUserData() {
        if (getIntent().getExtras() != null) {
            name = getIntent().getExtras().getString(KEY_USER);
            password = getIntent().getExtras().getString(KEY_PASSWORD);
        }
    }

    private void checkLocationPermission() {
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                    Boolean fineLocationGranted = result.getOrDefault(permissions[1], false);
                    Boolean coarseLocationGranted = result.getOrDefault(permissions[0], false);
                    if (fineLocationGranted != null && !fineLocationGranted ||
                            coarseLocationGranted != null && !coarseLocationGranted) {
                        showPermissionInfo();
                    } else {
                        userWelcome();
                        showNotification();
                    }
                });
        locationPermissionRequest.launch(permissions);
    }

    private void userWelcome() {
        Snackbar.make(binding.homeContainer, "Bienvenido " + name + " " + password, Snackbar.LENGTH_SHORT).show();
    }

    private void showPermissionInfo() {
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
        alertDialogBuilder
                .setTitle(R.string.requiredPermission)
                .setMessage(R.string.permissionDescription)
                .setCancelable(false)
                .setNeutralButton(R.string.exit, (dialog, which) -> {
                    dialog.dismiss();
                    finish();
                })
                .setPositiveButton(R.string.settings,
                        (dialog, which) -> {
                            dialog.dismiss();
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            finish();
                        })
                .show();
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_home_white_24dp)
                .setContentTitle(getString(R.string.welcome) + " " + name)
                .setContentText(getString(R.string.notification_text))
                .setAutoCancel(false)
                .setWhen(System.currentTimeMillis())
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.hd_wallpaper_gb3ae929a6_640)))
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                getString(R.string.channel_name), NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(getString(R.string.channel_description));
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}