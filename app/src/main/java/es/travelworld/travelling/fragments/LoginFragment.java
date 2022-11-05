package es.travelworld.travelling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentLoginBinding;
import es.travelworld.travelling.utilities.Validation;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private final Validation validations = new Validation();

    public LoginFragment() {}

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Toast.makeText(requireContext(), getArguments().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        listeners();
        return view;
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = super.onGetLayoutInflater(savedInstanceState);
        Context contextTheme = new ContextThemeWrapper(requireContext(), R.style.Theme_LoginActivity);
        return inflater.cloneInContext(contextTheme);
    }

    private void listeners() {
        binding.createAccount.setOnClickListener(v -> initRegisterFragment());

        binding.loginButton.setOnClickListener(v -> checkUserData(Objects.requireNonNull(binding.etLoginUser.getText()).toString(),
                Objects.requireNonNull(binding.etLoginPassword.getText()).toString()));

        binding.etLoginUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.loginButton.setEnabled(isButtonEnabled());
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
                binding.loginButton.setEnabled(isButtonEnabled());
            }
        });
    }

    private void getUserData() {
        //TODO RECOGER DATOS DE USER
    }

    private void checkUserData(String name, String password) {
        //TODO COMPROBAR DATOS USUARIO
    }

    private void showAlert() {
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
        alertDialogBuilder
                .setTitle(R.string.autentication_error)
                .setMessage(R.string.verify_data)
                .setPositiveButton(R.string.understood,
                        (dialog, which) -> dialog.cancel())
                .show();
    }

    private boolean isButtonEnabled() {
        return validations.isNotEmptyField(binding.etLoginUser)
                && validations.isNotEmptyField(binding.etLoginPassword);
    }

    private void initRegisterFragment() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, RegisterFragment.newInstance(), "RegisterFragment")
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}