package com.example.passwordvalidationview_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pvv_sdk.OnValidationListener;
import com.example.pvv_sdk.PasswordValidationView;

public class MainActivity extends AppCompatActivity {
    EditText passEditText;
    Button button;
    PasswordValidationView validationView;
    OnValidationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passEditText = findViewById(R.id.password_et);
        button = findViewById(R.id.btn);
        validationView = findViewById(R.id.);

        validationView.setPasswordEditText(passEditText);

        listener = new OnValidationListener() {
            @Override
            public void onUpdate(Boolean isValid) {
                button.setEnabled(isValid);
            }
        };


        validationView.setOnValidationListener(listener);
       // validationView.passwordMinLength = 10;


    }
}