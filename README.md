# Password Validator UI for Android
[![](https://jitpack.io/v/osnatlevi/PasswordValidationView_Pro.svg)](https://jitpack.io/#osnatlevi/PasswordValidationView_Pro)

This is A UI component that checks if a new password answers all the requirements for a legit passcode. 


# Screenshots
>| | | |
>|--|--|--|
>|<img src="https://github.com/osnatlevi/PasswordValidationView_Pro/assets/62397127/49a5f9a5-826c-40b0-b772-670b2fae0e03" alt="alt text" title="Sample App" width="300" height="650" border="10">|<img src="https://github.com/osnatlevi/PasswordValidationView_Pro/assets/62397127/1e96c730-2ee6-4b60-b5ff-2ceff107b133" alt="alt text" title="Sample App" width="300" height="650" border="10">|
>|<img src="https://github.com/osnatlevi/PasswordValidationView_Pro/assets/62397127/cb6996fc-d4ab-4dd2-ad07-75efb737dc1c" alt="alt text" title="Sample App" width="300" height="650" border="10">|<img src="https://github.com/osnatlevi/PasswordValidationView_Pro/assets/62397127/10afd10d-3abb-43af-87f8-5e4aa88cb7b8" alt="alt text" title="Sample App" width="300" height="650" border="10">|


# Features
>
>When making regestration with password, this UI can be user friendly. as the user will write down a password, the UI will tell in real time if the password stand with all the requirments. 
>

## Setup

>Add it in your root `build.gradle` at the end of repositories:
>
>```groovy
>allprojects {
>    repositories {
>        //...omitted for brevity
>        maven { url 'https://jitpack.io' }
>    }
>}
>```



>Add the dependency
>
>```groovy
>dependencies {
>    implementation 'com.github.osnatlevi:PasswordValidationView_Pro:Tag'
>}
>```
>

## Usage
- Add `PasswordValidationView` to your xml layout.
>
>```xml
>    <com.example.pvv_sdk.PasswordValidationView
>                android:id="@+id/pvvt"
>                android:layout_width="match_parent"
>                android:layout_height="wrap_content" />
>```

#### :bulb: `Important` : To avoid the keyboard from covering the validation view, place the view inside a `TextInputLayout` 

>```xml
>    <!-- The text input layout-->
><com.google.android.material.textfield.TextInputLayout
>      android:layout_centerInParent="true"
>      android:layout_width="match_parent"
>      android:layout_height="wrap_content"
>      android:hint="Password"
>      app:passwordToggleEnabled="true">
>
>      <com.google.android.material.textfield.TextInputEditText
>            android:id="@+id/password_et"
>            android:layout_width="match_parent"
>            android:layout_height="wrap_content"
>            android:layout_margin="20dp"
>            android:inputType="textPassword" />
>
>       <com.example.pvv_sdk.PasswordValidationView
>            android:id="@+id/pvvt"
>            android:layout_width="match_parent"
>            android:layout_height="wrap_content" />
>
></com.google.android.material.textfield.TextInputLayout>
>```

### How to initialize the view:
>All the following steps will be under `OnCreate()` method:
>
>#### declaration and initiations:
>>```java
>>        EditText passEditText = findViewById(R.id.password_et); // Get The Edit Text.
>>        PasswordValidationView validationView = findViewById(R.id.pvvt); // Get The Validation View
>>        Button button = findViewById(R.id.btn); // Optional: If you use a button.
>>
>>        validationView.setPasswordEditText(passEditText); //Passes the edittext to the validator
>>```
>#### Check if the password is complete and valid
>>```java
>>        listener = new OnValidationListener() {  // Create a listener that will get the status of the password
>>            @Override
>>            public void onUpdate(Boolean isValid) {
>>                //***if Valid do something**//
>>                //e.g.:
>>                button.setEnabled(isValid);
>>            }
>>        };
>>
>>        validationView.setOnValidationListener(listener); //Passes the listener to the validator !
>>```
>>

# Enjoy! :)
