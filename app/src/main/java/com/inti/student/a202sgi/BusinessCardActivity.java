package com.inti.student.a202sgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BusinessCardActivity extends AppCompatActivity {
    private Button mButtonView;
    private Button mButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mButtonView = (Button)findViewById(R.id.btnView);
        mButtonView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewActivity();
            }
        }));

        mButtonAdd = (Button)findViewById(R.id.btnAdd);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewActivity();
            }
        });
    }

    protected void openViewActivity() {
        Intent intent = new Intent(this, BusinessCardListActivity.class);
        startActivity(intent);
    }

    protected void openAddNewActivity() {
        Intent intent = new Intent(this, BusinessCardNew.class);
        startActivity(intent);
    }
}
