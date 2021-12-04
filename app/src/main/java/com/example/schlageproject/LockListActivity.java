package com.example.schlageproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LockListActivity extends AppCompatActivity implements DisplayLockAdapter.ItemClickListener {
    TextView lockListBannerText;
    RecyclerView lockListRecyclerView;
    DisplayLockAdapter displayLockAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_lock_list_page);

        lockListBannerText = (TextView) findViewById(R.id.editTextTextPassword);

        lockListRecyclerView = (RecyclerView) findViewById(R.id.lockListPageRecyclerView);
        lockListRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        displayLockAdapter = new DisplayLockAdapter(getApplicationContext(), generateLockData());
        displayLockAdapter.setClickListener(this);

        lockListRecyclerView.setAdapter(displayLockAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // When a lock is clicked from list, create a new Lock Information View and swap to that.
        viewLockInfo(position);
    }

    private List<DisplayLock> generateLockData() {
        // Poll API for lock data
        // Currently just populate with examples as Tanner didn't write any code
        List<DisplayLock> lockData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lockData.add(new DisplayLock("Example Name", "Example ID"));
        }
        return lockData;
    }

    private void viewLockInfo(int position) {
        // Pass lock id to new page, populate it with with a full Lock.
        Intent intent = new Intent(getApplicationContext(), Lock.class);
    }
}
