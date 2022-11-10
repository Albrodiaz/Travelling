package es.travelworld.travelling.view;

import static es.travelworld.travelling.Constants.TAG_LOGINFRAGMENT;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

import es.travelworld.travelling.databinding.ActivityLoginBinding;
import es.travelworld.travelling.view.fragments.loginFragments.LoginFragment;
import es.travelworld.travelling.view.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        initLoginFragment();
        listeners();
        hideToolbar();
    }

    private void hideToolbar() {
        loginViewModel.getFragmentSelected().observe(this, fragment -> {
            if (Objects.equals(fragment.getTag(), TAG_LOGINFRAGMENT)) {
                binding.registerAppbarLayout.setVisibility(View.GONE);
            } else {
                binding.registerAppbarLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.fragmentContainer.getId(), new LoginFragment(), TAG_LOGINFRAGMENT)
                .commitAllowingStateLoss();
    }

    private void listeners() {
        binding.registerToolbar.setNavigationOnClickListener(v -> super.onBackPressed());
    }
}