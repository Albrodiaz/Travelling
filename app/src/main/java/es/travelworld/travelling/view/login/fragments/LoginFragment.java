package es.travelworld.travelling.view.login.fragments;

import static es.travelworld.travelling.utilities.Constants.KEY_PASSWORD;
import static es.travelworld.travelling.utilities.Constants.KEY_USER;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentLoginBinding;
import es.travelworld.travelling.domain.User;
import es.travelworld.travelling.utilities.Validation;
import es.travelworld.travelling.view.login.RegisterViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private final Validation validations = new Validation();
    private RegisterViewModel registerViewModel;
    private User currentUser;

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        getUserData();
        listeners();
    }

    //Aplicamos tema al fragment
    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = super.onGetLayoutInflater(savedInstanceState);
        Context contextTheme = new ContextThemeWrapper(requireContext(), R.style.Theme_LoginActivity);
        return inflater.cloneInContext(contextTheme);
    }

    private void listeners() {

        binding.createAccount.setOnClickListener(v -> Navigation.findNavController(requireView())
                .navigate(R.id.action_loginFragment_to_registerFragment));

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
        currentUser = registerViewModel.getCurrentUser().getValue();
    }

    private void checkUserData(String name, String password) {

        if (currentUser != null
                && Objects.equals(currentUser.getUserName(), name)
                && Objects.equals(currentUser.getUserPassword(), password)) {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_loginFragment_to_homeActivity, setData());
            requireActivity().finish();
        } else {
            showAlert();
        }
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

    private Bundle setData() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_USER, currentUser.getUserName());
        bundle.putString(KEY_PASSWORD, currentUser.getUserPassword());
        return bundle;
    }
}