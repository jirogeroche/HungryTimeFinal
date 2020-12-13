package com.example.hungrytime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText mLastName, mFirstName, mPassword, mConfirmPassword, mEmail;
    Button mRegisterBtn;
    //TextView mLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mLastName = findViewById(R.id.txtLastName);
        mFirstName = findViewById(R.id.txtFirstName);
        mPassword = findViewById(R.id.txtPassword);
        mConfirmPassword = findViewById(R.id.txtConfirmPassword);
        mEmail = findViewById(R.id.txtPassword2);
        mRegisterBtn = findViewById(R.id.btnRegister);
        //mLoginBtn = findViewById(R.id.btnSignIn);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String confirmPassword = mConfirmPassword.getText().toString().trim();
                String lastName = mLastName.getText().toString().trim();
                String firstName = mFirstName.getText().toString().trim();


                if(TextUtils.isEmpty(lastName)){
                    mLastName.setError("Please input your last name.");
                    return;
                }
                if(TextUtils.isEmpty(firstName)){
                    mFirstName.setError("Please input your first name.");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)) {
                    mConfirmPassword.setError("Please confirm your password.");
                    return;
                }
                if(password.length() < 6) {
                    mPassword.setError("Password must be greater than 6 characters.");
                    return;
                }

/*
                if(confirmPassword != password) {
                    mConfirmPassword.setError("Password does not match");
                    return;
                }

 */

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this, "You have successfully created your account. Welcome !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }else{
                            Toast.makeText(SignUp.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        }

    public void signUp(View view){
        Intent signUpIntent = new Intent(SignUp.this, HomeActivity.class);
        startActivity(signUpIntent);
        finish();
    }

    public void goToSignIn(View view){
        Intent goToSignInIntent = new Intent(SignUp.this, SignIn.class);
        startActivity(goToSignInIntent);
        finish();
    }
}