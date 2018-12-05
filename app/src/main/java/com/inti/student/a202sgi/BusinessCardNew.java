package com.inti.student.a202sgi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BusinessCardNew extends AppCompatActivity {
    private BusinessCard mBusinessCard;
    private Button mSaveButtom;

    EditText txtFName, txtLName, txtContact, txtEmail, txtJobTitle, txtCompName, txtCompAdd, txtCompURL;
    DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bs_new);
        mDatabase = new DatabaseHelper(this);

        txtFName = (EditText)findViewById(R.id.firstNameInput);
        txtLName = (EditText)findViewById(R.id.lastNameInput);
        txtContact = (EditText)findViewById(R.id.contactNoInput);
        txtEmail = (EditText)findViewById(R.id.emailInput);
        txtJobTitle = (EditText)findViewById(R.id.jobTitleInput);
        txtCompName = (EditText)findViewById(R.id.companyNameInput);
        txtCompAdd = (EditText)findViewById(R.id.companyAddressInput);
        txtCompURL = (EditText)findViewById(R.id.companyURLInput);
        mSaveButtom = (Button)findViewById(R.id.btnSave);

        AddData();
    }

    public void AddData() {
        mSaveButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mDatabase.insertData(txtFName.getText().toString(),
                        txtLName.getText().toString(),
                        txtContact.getText().toString(),
                        txtEmail.getText().toString(),
                        txtJobTitle.getText().toString(),
                        txtCompName.getText().toString(),
                        txtCompAdd.getText().toString(),
                        txtCompURL.getText().toString());

                if (isInserted == true) {
                    Toast.makeText(BusinessCardNew.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
                    MainMenu();
                }
                else {
                    Toast.makeText(BusinessCardNew.this, "Data inserted unsuccessfully", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void MainMenu() {
        Intent intent = new Intent(this, BusinessCardActivity.class);
        startActivity(intent);
    }
}
