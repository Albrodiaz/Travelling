package es.travelworld.travelling;

import static es.travelworld.travelling.Constants.KEY_USERNAME;
import static es.travelworld.travelling.Constants.KEY_USERSURNAME;
import static es.travelworld.travelling.Constants.REQUEST_IMAGE_CAPTURE;
import static es.travelworld.travelling.Constants.TERMSWEB;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import es.travelworld.travelling.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private final Validation validations = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initAdapter();
        listeners();
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
                binding.btnRegister.setEnabled(validations.isNotEmptyField(binding.etName)
                        && validations.isNotEmptyField(binding.etSurname)
                        && !binding.layoutName.isErrorEnabled()
                        && !binding.layoutSurname.isErrorEnabled());
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
                binding.btnRegister.setEnabled(validations.isNotEmptyField(binding.etName)
                        && validations.isNotEmptyField(binding.etSurname)
                        && !binding.layoutName.isErrorEnabled()
                        && !binding.layoutSurname.isErrorEnabled());
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
            }
        });

        binding.acRange.setOnFocusChangeListener((v, hasFocus) -> {
            if (v.hasFocus()) {
                hideKeyboard(v);
            }
        });

        binding.ivCamera.setOnClickListener(v -> initCamera());

        binding.tvConditions.setOnClickListener(v -> openConditions());

        binding.regiterToolbar.setNavigationOnClickListener(v -> onBackPressed());

        binding.btnRegister.setOnClickListener(v -> register(binding.etName.getText().toString()
                , binding.etSurname.getText().toString()));
    }

    private void initAdapter() {
        String[] items = getResources().getStringArray(R.array.age_range);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, items);
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
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    private void register(String name, String surname) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(KEY_USERNAME, name);
        intent.putExtra(KEY_USERSURNAME, surname);
        startActivity(intent);
        finish();
    }
}