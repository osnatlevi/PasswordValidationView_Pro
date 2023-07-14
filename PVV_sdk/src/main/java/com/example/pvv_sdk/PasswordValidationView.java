package com.example.pvv_sdk;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kotlin.text.Regex;

public class PasswordValidationView extends LinearLayout {




// Core Items/
    private Context mContext;
    private AttributeSet attrs;
    private int styleAttr;
    private View view;

    EditText passwordEditText;
    boolean isLower, isUpper, isDigit, isSpecialChar, isLengthy;
    OnValidationListener onValidationListener;

    Boolean isPasswordValid  = false;

    Pattern pattern;

    // specialCharRegex  = Regex("[!\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~]]");
    TextView lowerCaseSymbol, lowerCaseTv, upperCaseSymbol, upperCaseTv, digitsSymbol, digitsTv, lengthSymbol, lengthTv
            , specialCharSymbol, specialCharTv ;


    int gray, enabledColor;
    public PasswordValidationView (Context context){
        super(context);
        this.mContext = context;
        initView();
    }

    public PasswordValidationView (Context context, AttributeSet attrs){
        super(context,attrs);
        this.mContext = context;
        this.attrs = attrs;
        initView();
    }
    public PasswordValidationView (Context context,AttributeSet attrs, int styleAttr){
        super(context,attrs,styleAttr);
        this.mContext = context;
        this.attrs = attrs;
        this.styleAttr = styleAttr;
        initView();
    }

    private void initView(){
        gray  = ContextCompat.getColor(mContext, R.color.gray);
        enabledColor   = ContextCompat.getColor(mContext, R.color.colorPrimary);
       pattern =  Pattern.compile("[^a-zA-Z0-9]");

      this.view = this;
      LayoutInflater.from(mContext).inflate(R.layout.password_validation_view, this);

       isLower = false;
       isUpper = false;
       isDigit = false;
       isSpecialChar = false;
       isLengthy = false;

       findViews();


       passwordEditText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               validatePassword(s.toString());
               checkValidation(s.toString());
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

    }

    private void findViews() {
       lowerCaseSymbol = findViewById(R.id.lower_case_symbol);
       lowerCaseTv = findViewById(R.id.lower_case_tv);

       upperCaseSymbol = findViewById(R.id.upper_case_symbol);
       upperCaseTv = findViewById(R.id.upper_case_tv);

       digitsSymbol = findViewById(R.id.digits_symbol);
        digitsTv = findViewById(R.id.digits_tv);

        lengthSymbol = findViewById(R.id.length_symbol);
        lengthTv = findViewById(R.id.length_tv);

        specialCharSymbol = findViewById(R.id.special_char_symbol);
        specialCharTv = findViewById(R.id.special_char_tv);
    }

    public void setOnValidationListener ( OnValidationListener listener) {
        this.onValidationListener = listener;
    }
    public void setPasswordEditText(EditText editText){
        this.passwordEditText = editText;
    }


    private void validatePassword(String string){
        if (!string.isEmpty() || string.chars().anyMatch(Character::isLowerCase)) {
            //lowercase
            lowerCaseSymbol.setTextColor(gray);
            lowerCaseTv.setTextColor(gray);

            isLower = false;
        }
        if (!string.isEmpty() || string.chars().anyMatch(Character::isUpperCase)) {
            //uppercase
            upperCaseSymbol.setTextColor(gray);
            upperCaseTv.setTextColor(gray);

            isUpper = false;
        }
        if (!string.isEmpty() || string.chars().anyMatch(Character::isDigit)) {
            //digits
            digitsSymbol.setTextColor(gray);
            digitsTv.setTextColor(gray);

            isDigit = false;
        }
        if (!string.isEmpty() || string.length() < 10) {
            //length
            lengthSymbol.setTextColor(gray);
            lengthTv.setTextColor(gray);

            isLengthy = false;
        }
        Matcher matcher = pattern.matcher(string);
        boolean isStringContainsSpecialCharacter = matcher.find();

        if (!string.isEmpty() || isStringContainsSpecialCharacter) {
            //special characters
            specialCharSymbol.setTextColor(gray);
            specialCharTv.setTextColor(gray);

            isSpecialChar = false;
        }
        if (string.chars().anyMatch(Character::isLowerCase)) {
            lowerCaseSymbol.setTextColor(gray);
            lowerCaseTv.setTextColor(gray);

            if (!isLower) {
                animateSymbol(lowerCaseSymbol);
                isLower = true;
            }
        }
        /////////
        if (string.chars().anyMatch(Character::isUpperCase)) {
            upperCaseSymbol.setTextColor(enabledColor);
            upperCaseTv.setTextColor(enabledColor);

            if (!isUpper) {
                animateSymbol(upperCaseSymbol);
                isUpper = true;
            }
        }
        if (string.chars().anyMatch(Character::isDigit)) {
            digitsSymbol.setTextColor(enabledColor);
            digitsTv.setTextColor(enabledColor);

            if (!isDigit) {
                animateSymbol(digitsSymbol);
                isDigit = true;
            }
        }
        if (string.length() >= 10) {
            lengthSymbol.setTextColor(enabledColor);
            lengthTv.setTextColor(enabledColor);

            if (!isLengthy) {
                animateSymbol(lengthSymbol);
                isLengthy = true;
            }
        }
        if (isStringContainsSpecialCharacter) {
            specialCharSymbol.setTextColor(enabledColor);
            specialCharTv.setTextColor(enabledColor);

            if (!isSpecialChar) {
                animateSymbol(specialCharSymbol);
                isSpecialChar = true;
            }
        }

    }

    private void animateSymbol(View view ) {
        YoYo.with(Techniques.Tada)
                .duration(900)
                .playOn(view);
    }

    private void checkValidation(String string) {
        isPasswordValid = (!string.isEmpty()
                && isLower
                && isUpper
                && isDigit
                && isLengthy
                && isSpecialChar);
        this.onValidationListener.onUpdate(isPasswordValid);
    }





}