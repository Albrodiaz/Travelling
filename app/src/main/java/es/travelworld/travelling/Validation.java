package es.travelworld.travelling;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

public class Validation {
    public boolean isValidChar(@NonNull String text) {
        boolean flag = true;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '@' || text.charAt(i) == '!') {
                flag = false;
            }
        }
        return !flag;
    }

    public boolean isNotEmptyField(@NonNull TextInputEditText firstText, TextInputEditText secondText) {
        return !TextUtils.isEmpty(firstText.getText().toString()) && !TextUtils.isEmpty(secondText.getText().toString());
    }
}
