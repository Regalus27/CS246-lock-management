package com.example.schlageproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccessCodeManageActivity extends AppCompatActivity implements View.OnClickListener {
    TextView accessCodeTextView;
    EditText editTextChangeCode;
    Button changeAccessCodeButton;
    Button deleteAccessCodeButton;

    AccessCode accessCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access_code_manage_page);

        accessCode = getIntent().getParcelableExtra("Access Code");

        accessCodeTextView = (TextView) findViewById(R.id.accessCodeTextView);
        accessCodeTextView.setText(accessCode.getAccessCode());

        editTextChangeCode = (EditText) findViewById(R.id.editTextChangeCode);

        changeAccessCodeButton = (Button) findViewById(R.id.changeCodeButton);
        deleteAccessCodeButton = (Button) findViewById(R.id.deleteCodeButton);

        changeAccessCodeButton.setOnClickListener(this);
        deleteAccessCodeButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changeCodeButton:
                changeAccessCode();
                break;
            case R.id.deleteCodeButton:
                deleteAccessCode();
                break;
            default:
                break;
        }
    }

    private void changeAccessCode() {
        // Pop-up window, enter new code
        // Use API to change code
        // I cannot simulate this locally, as all Lock and AccessCode member variables are final
        //     as all changes are to be made server-side.
        accessCodeTextView.setText(editTextChangeCode.getText());
        Log.d("changeAccessCode", "changeAccessCode called, unable to simulate locally.");
    }

    private void deleteAccessCode() {
        // Use API to delete code, end activity
        // Again, very annoying to simulate without the API, would involve either global vars or
        // creating a new instance of the previous page with a hard-coded intent to delete the
        // access code with a specific id.
        Log.d("deleteAccessCode()", "deleteAccessCode called, unable to simulate locally");
        finish();
    }
}
