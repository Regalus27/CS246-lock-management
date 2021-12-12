package com.example.schlageproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LockViewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView lockName;
    TextView modelName;
    TextView serialNumber;
    TextView lockID;
    TextView lockBatteryState;
    Button manageAccessCodes;
    TextView lockState;

    Lock lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock_information_page);

        lock = pullLockData(getIntent().getStringExtra("Lock ID"));

        lockName = findViewById(R.id.lockName);
        lockName.setText(lock.getName());

        modelName = findViewById(R.id.modelName);
        modelName.setText(lock.getModelName());

        serialNumber = findViewById(R.id.serialNumber);
        serialNumber.setText(lock.getSerialNumber());

        lockID = findViewById(R.id.lockID);
        lockID.setText(lock.getLockID());

        lockBatteryState = findViewById(R.id.accessCodeTextView);
        lockBatteryState.setText(lock.getLockBatteryState().toString());

        lockState = findViewById(R.id.lockState);
        lockState.setText(lock.getLockState().toString());

        manageAccessCodes = findViewById(R.id.manageAccessCodesButton);
        manageAccessCodes.setOnClickListener(this);

        Log.d("LOCKVIEW", "Page successfully initialized");
    }

    @Override
    public void onClick(View v) {
        Log.d("LOCKVIEW", "onClick: should open new page");

        viewAccessCodes();
    }

    private void viewAccessCodes() {
        Intent intent = new Intent(getApplicationContext(), AccessCodeListActivity.class);
        intent.putExtra("Lock ID", lock.getLockID());
        startActivity(intent);
    }

    private Lock pullLockData(String lockID) {
        // API stuff here
        return new Lock(LockState.LOCKED, LockBatteryState.NORMAL, "Schlage Lock", "0000000000", lockID, "Lock", new ArrayList<AccessCode>());
    }
}
