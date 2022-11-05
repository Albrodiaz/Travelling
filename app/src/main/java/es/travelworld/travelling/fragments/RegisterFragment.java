package es.travelworld.travelling.fragments;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static es.travelworld.travelling.Constants.REQUEST_IMAGE_CAPTURE;
import static es.travelworld.travelling.Constants.TERMSWEB;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentRegisterBinding;
import es.travelworld.travelling.utilities.Validation;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private final Validation validations = new Validation();

    public RegisterFragment() {
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        listeners();
        initAdapter();

        return view;
    }

    @NonNull
    @Override
    //Método para aplicar tema al Fragment
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = super.onGetLayoutInflater(savedInstanceState);
        Context contextTheme = new ContextThemeWrapper(requireContext(), R.style.Theme_RegisterActivity);
        return inflater.cloneInContext(contextTheme);
    }

    private void listeners() {
        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (validations.isValidChar(s.toString())) {
                    binding.layoutName.setError("Ups, no creo que sea correcto, revísalo");
                } else {
                    binding.layoutName.setErrorEnabled(false);
                }
                binding.btnRegister.setEnabled(isButtonEnabled());
            }
        });

        binding.etSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (validations.isValidChar(s.toString())) {
                    binding.layoutSurname.setError("Ups, no creo que sea correcto, revísalo");
                } else {
                    binding.layoutSurname.setErrorEnabled(false);
                }
                binding.btnRegister.setEnabled(isButtonEnabled());
            }
        });

        binding.acRange.addTextChangedListener(new TextWatcher() {
            final String[] agerange = getResources().getStringArray(R.array.age_range);

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(agerange[agerange.length - 1])) {
                    binding.layoutAge.setError("Esta app no es para ti");
                } else {
                    binding.layoutAge.setErrorEnabled(false);
                }
                binding.btnRegister.setEnabled(isButtonEnabled());
            }
        });

        binding.acRange.setOnFocusChangeListener((v, hasFocus) -> {
            if (v.hasFocus()) {
                hideKeyboard(v);
            }
        });

        binding.ivCamera.setOnClickListener(v -> initCamera());

        binding.tvConditions.setOnClickListener(v -> openConditions());

        binding.btnRegister.setOnClickListener(v -> register(binding.etName.getText().toString()
                , binding.etSurname.getText().toString()));
    }

    private void initAdapter() {
        String[] items = getResources().getStringArray(R.array.age_range);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_item, items);
        ((AutoCompleteTextView) binding.acRange).setAdapter(adapter);
    }

    private void initCamera() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        try {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Log.w("Error", e);
        }
    }

    private void openConditions() {
        Uri web = Uri.parse(TERMSWEB);
        startActivity(new Intent(Intent.ACTION_VIEW, web));
    }

    private void hideKeyboard(@NonNull View v) {
        InputMethodManager imm =
                (InputMethodManager) requireActivity().getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    private void register(String name, String surname) {
        //TODO ENVIAR DATOS DE USUARIO A ACTIVITY
    }

    private boolean isButtonEnabled() {
        return validations.isNotEmptyField(binding.etName)
                && validations.isNotEmptyField(binding.etSurname)
                && !binding.layoutName.isErrorEnabled()
                && !binding.layoutSurname.isErrorEnabled()
                && !binding.layoutAge.isErrorEnabled();
    }
}