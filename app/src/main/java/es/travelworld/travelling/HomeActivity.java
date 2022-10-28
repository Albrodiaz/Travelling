package es.travelworld.travelling;

import static es.travelworld.travelling.Constants.EURODISNEYWEB;
import static es.travelworld.travelling.Constants.KEY_USERLOGIN;
import static es.travelworld.travelling.Constants.KEY_USERPASWORD;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

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
        setContentView(binding.getRoot());
        getExtraData();
        listeners();

    }

    private void getExtraData() {
        if (getIntent().getExtras() != null) {
            username = getIntent().getExtras().getString(KEY_USERLOGIN);
            userSurname = getIntent().getExtras().getString(KEY_USERPASWORD);
        }
        Log.e("Welcome", "Bienvenido " + username + " " + userSurname);
    }

    private void listeners() {
        binding.homeToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
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
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Anular botón atrás
    }
}