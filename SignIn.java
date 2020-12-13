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

public class SignIn extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPassword);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.btnSignIn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }
                if(password.length() < 6) {
                    mPassword.setError("Password must be greater than 6 characters.");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignIn.this, "Logged In Successfully. Welcome !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }else {
                            Toast.makeText(SignIn.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    public void signIn(View view){
        Intent signInIntent = new Intent(SignIn.this, HomeActivity.class);
        startActivity(signInIntent);
        finish();
    }

    public void signUp(View view){
        Intent signUpIntent = new Intent(SignIn.this, SignUp.class);
        startActivity(signUpIntent);
        finish();
    }
}



