package com.example.passwordvalidationview_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText passEditText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         passEditText = findViewById(R.id.password_et);
        button = findViewById(R.id.btn);
                //val validationView = findViewById(R.id.pvv)






    }
}