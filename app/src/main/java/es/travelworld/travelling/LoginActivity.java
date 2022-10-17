package es.travelworld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import es.travelworld.travelling.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        listeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.get_new):
            case (R.id.create_account):
                Snackbar.make(v, R.string.coming_soon, Snackbar.LENGTH_SHORT).show();
                break;
            case (R.id.login_button):
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    private void listeners() {
        binding.getNew.setOnClickListener(this);
        binding.createAccount.setOnClickListener(this);
        binding.loginButton.setOnClickListener(this);
    }
}