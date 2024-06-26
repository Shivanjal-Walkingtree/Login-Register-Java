package com.example.loginregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText email_login,password_login;
    Button logbt;
    TextView signupText;
    int googleAuth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        logbt = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText);

        logbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email_login.getText().toString()) || TextUtils.isEmpty(password_login.getText().toString())){
                    String message = "All fields required !!";
                    Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                }else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(email_login.getText().toString());
                    loginRequest.setPassword(password_login.getText().toString());
                    loginRequest.setIsGoogleAuth(googleAuth);

                    loginUser(loginRequest);

                }

            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void loginUser(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(Login.this,MainActivity.class).putExtra("data",loginResponse));
                    finish();

                }else{
                    String message = "An error occured";
                    Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Login.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

}