package es.travelworld.travelling;

import static es.travelworld.travelling.Constants.KEY_USERLOGIN;
import static es.travelworld.travelling.Constants.KEY_USERNAME;
import static es.travelworld.travelling.Constants.KEY_USERPASWORD;
import static es.travelworld.travelling.Constants.KEY_USERSURNAME;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import es.travelworld.travelling.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String userName;
    private String userPassword;
    private final Validation validations = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getUserData();
        listeners();
    }

    private void listeners() {
        binding.createAccount.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));

        binding.loginButton.setOnClickListener(v -> checkUserData(binding.etLoginUser.getText().toString(),
                binding.etLoginPassword.getText().toString(), v));

        binding.etLoginUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.loginButton.setEnabled(validations.isNotEmptyField(binding.etLoginUser)
                        && validations.isNotEmptyField(binding.etLoginPassword));
            }
        });

        binding.etLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.loginButton.setEnabled(validations.isNotEmptyField(binding.etLoginUser)
                        && validations.isNotEmptyField(binding.etLoginPassword));
            }
        });
    }

    private void getUserData() {
        if (getIntent().getExtras() != null) {
            userName = getIntent().getExtras().getString(KEY_USERNAME);
            userPassword = getIntent().getExtras().getString(KEY_USERSURNAME);
        }
    }

    private void checkUserData(String name, String password, View v) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(KEY_USERLOGIN, name);
        intent.putExtra(KEY_USERPASWORD, password);
        if (Objects.equals(name, userName) && Objects.equals(password, userPassword)) {
            startActivity(intent);
        } else {
            Snackbar.make(v, R.string.bad_request, Snackbar.LENGTH_SHORT).show();
        }
    }
}