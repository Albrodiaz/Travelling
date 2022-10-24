package es.travelworld.travelling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import es.travelworld.travelling.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

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
                if (isValidChar(s.toString())) {
                    binding.layoutName.setError("Ups, no creo que sea correcto, revísalo");
                } else {
                    binding.layoutName.setErrorEnabled(false);
                }
                binding.btnRegister.setEnabled(isEmptyField(binding.etName, binding.etSurname));
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
                if (isValidChar(s.toString())) {
                    binding.layoutSurname.setError("Ups, no creo que sea correcto, revísalo");
                } else {
                    binding.layoutSurname.setErrorEnabled(false);
                }
                binding.btnRegister.setEnabled(isEmptyField(binding.etName, binding.etSurname));
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
                binding.btnRegister.setEnabled(isEmptyField(binding.etName, binding.etSurname));
            }
        });
        binding.acRange.setOnFocusChangeListener((v, hasFocus) -> {
            if (v.hasFocus()) {
                hideKeyboard(v);
            }
        });
        binding.ivCamera.setOnClickListener(v -> initCamera());
        binding.tvConditions.setOnClickListener(v -> openConditions());
    }

    private void initAdapter() {
        String[] items = getResources().getStringArray(R.array.age_range);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, items);
        ((AutoCompleteTextView) binding.acRange).setAdapter(adapter);
    }

    private boolean isValidChar(@NonNull String text) {
        boolean flag = true;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '@' || text.charAt(i) == '!') {
                flag = false;
            }
        }
        return !flag;
    }

    private boolean isEmptyField(@NonNull TextInputEditText firstText, TextInputEditText secondText) {
        return firstText.getText().length() > 0 && secondText.getText().length() > 0
                && !binding.layoutName.isErrorEnabled() && !binding.layoutSurname.isErrorEnabled();
    }

    private void initCamera() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void openConditions() {
        Uri web = Uri.parse("https://developers.google.com/ml-kit/terms");
        startActivity(new Intent(Intent.ACTION_VIEW, web));
    }

    private void hideKeyboard(@NonNull View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}