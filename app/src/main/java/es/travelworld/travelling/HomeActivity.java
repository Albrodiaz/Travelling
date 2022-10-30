package es.travelworld.travelling;

import static es.travelworld.travelling.Constants.EURODISNEYWEB;
import static es.travelworld.travelling.Constants.KEY_USERLOGIN;
import static es.travelworld.travelling.Constants.KEY_USERPASWORD;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import es.travelworld.travelling.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    Fragment carFragment = new CarFragment();
    private String username;
    private String userSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getExtraData(view);
        listeners();

    }

    private void getExtraData(View v) {
        if (getIntent().getExtras() != null) {
            username = getIntent().getExtras().getString(KEY_USERLOGIN);
            userSurname = getIntent().getExtras().getString(KEY_USERPASWORD);
        }
        Snackbar.make(v, "Bienvenido " + username + " " + userSurname, Snackbar.LENGTH_SHORT).show();
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
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer, carFragment ).commit();
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