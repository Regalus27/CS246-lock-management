package com.example.schlageproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AccessCodeListActivity extends AppCompatActivity implements AccessCodeAdapter.ItemClickListener {
    RecyclerView accessCodeListView;
    AccessCodeAdapter accessCodeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_access_code_list_page);


        accessCodeListView = (RecyclerView) findViewById(R.id.accessListRecyclerView);
        accessCodeListView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        accessCodeAdapter = new AccessCodeAdapter(getApplicationContext(), pullAccessCodes());
        accessCodeAdapter.setClickListener(this);

        accessCodeListView.setAdapter(accessCodeAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // Interact with clicked access code.
        viewAccessCode(position);
    }

    private List<AccessCode> pullAccessCodes() {
        // Poll API for access codes for a lock
        // Currently just populate with examples as Tanner didn't write any code
        // lockID stored in intent, "lock ID"
        List<AccessCode> accessCodeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            accessCodeList.add(new AccessCode("Example Access Code", "0000", "0000"));
        }
        return accessCodeList;
    }

    private void viewAccessCode(int position) {
        Intent intent = new Intent(getApplicationContext(), AccessCodeManageActivity.class);
        intent.putExtra("Access Code", accessCodeAdapter.getItem(position));
        startActivity(intent);
    }
}
