package es.travelworld.travelling;

import static es.travelworld.travelling.Constants.KEY_USERLOGIN;
import static es.travelworld.travelling.Constants.KEY_USERPASWORD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    private String username;
    private String userSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getExtraData();
    }

    private void getExtraData(){
        if (getIntent().getExtras() != null && getIntent().getExtras() != null) {
            username = getIntent().getExtras().getString(KEY_USERLOGIN);
            userSurname = getIntent().getExtras().getString(KEY_USERPASWORD);
        }
        Log.e("Welcome", "Bienvenido " + username + " " + userSurname);
    }
}