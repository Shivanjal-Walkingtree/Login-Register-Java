package com.example.loginregisterapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LoginResponse loginResponse;
    TextView message,name,email,role;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        role = findViewById(R.id.role);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");

            message.setText(loginResponse.getData().getUserId());
            name.setText(loginResponse.getData().getFullName());
            email.setText(loginResponse.getData().getEmail());
            role.setText(loginResponse.getData().getRole());

            Log.e("TAG","====> "+loginResponse.getData().getUserId());
            Log.e("TAG","====> "+loginResponse.getData().getFullName());
            Log.e("TAG","====> "+loginResponse.getData().getEmail());
            Log.e("TAG","====> "+loginResponse.getData().getRole());
        }

    }
}