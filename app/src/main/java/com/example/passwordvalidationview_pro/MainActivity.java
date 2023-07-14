package com.example.passwordvalidationview_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pvv_sdk.OnValidationListener;
import com.example.pvv_sdk.PasswordValidationView;

public class MainActivity extends AppCompatActivity {
    private EditText passEditText;

    private ImageView background;
    private Button button;
    private PasswordValidationView validationView;
    private OnValidationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        Glide
                .with(this)
                .load("https://github.com/DorelSaig/WeatherView/assets/62397127/74d9721b-3bec-4535-b245-cf9d610e377d")
                .dontAnimate()
                .centerCrop()
                .into(background);

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

    private void findViews() {
        background = findViewById(R.id.backgroud);
        passEditText = findViewById(R.id.password_et);
        button = findViewById(R.id.btn);
        validationView = findViewById(R.id.pvvt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Greetings Mate!", Toast.LENGTH_LONG).show();
                passEditText.setText("");
            }
        });
    }
}