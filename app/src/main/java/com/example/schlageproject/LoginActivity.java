package com.example.schlageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewAppName;
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        textViewAppName = (TextView) findViewById(R.id.textViewAppName);
        buttonLogin = (Button) findViewById(R.id.login_button);
        editTextUsername = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        buttonLogin.setOnClickListener(this);
    }

    public void login() {
        // Change view to account_lock_list_page
        Intent intent = new Intent(getApplicationContext(), LockListActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        login();
    }
}