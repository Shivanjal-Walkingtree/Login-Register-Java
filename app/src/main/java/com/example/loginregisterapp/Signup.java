package com.example.loginregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {

    EditText username_signup, email_signup, password_signup, role_signup;
    Button signup_button;
    TextView logtext;
    int googleAuth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username_signup = findViewById(R.id.username_signup);
        email_signup = findViewById(R.id.email_signup);
        password_signup = findViewById(R.id.password_signup);
        role_signup = findViewById(R.id.role_signup);
        signup_button = findViewById(R.id.signup_Button);
        logtext = findViewById(R.id.logText);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(username_signup.getText().toString()) || TextUtils.isEmpty(email_signup.getText().toString())
                || TextUtils.isEmpty(password_signup.getText().toString()) || TextUtils.isEmpty(role_signup.getText().toString())) {

                    String message = "All field required !!";
                    Toast.makeText(Signup.this, message, Toast.LENGTH_SHORT).show();
                }else{

                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setFullName(username_signup.getText().toString());
                    registerRequest.setEmail(email_signup.getText().toString());
                    registerRequest.setPassword(password_signup.getText().toString());
                    registerRequest.setRole(role_signup.getText().toString());
                    registerRequest.setIsGoogleAuth(googleAuth);
                    registerUser(registerRequest);
                }
            }
        });

        logtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void registerUser(RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                
                 if(response.isSuccessful()){
                     String message = "Successful ..";
                     Toast.makeText(Signup.this, message, Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Signup.this,Login.class));
                     finish();
                 }else{
                     String message = "An error occured";
                     Toast.makeText(Signup.this, message, Toast.LENGTH_SHORT).show();
                 }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Signup.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }

}