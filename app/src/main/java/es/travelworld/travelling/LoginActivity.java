package es.travelworld.travelling;

import static es.travelworld.travelling.Constants.TAG_LOGINFRAGMENT;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import es.travelworld.travelling.databinding.ActivityLoginBinding;
import es.travelworld.travelling.fragments.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initLoginFragment();
    }

    private void initLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.fragmentContainer.getId(), LoginFragment.newInstance(), TAG_LOGINFRAGMENT)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}