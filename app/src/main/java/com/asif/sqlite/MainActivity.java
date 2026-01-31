package com.asif.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edName, edMobile;
    Button buttonInsert, buttonShow;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edMobile = findViewById(R.id.edMobile);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonShow = findViewById(R.id.buttonShow);

        dbHelper = new DatabaseHelper(MainActivity.this);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // insert er code hobe ekhane..

                dbHelper.insertData(edName.getText().toString(), edMobile.getText().toString());
                Toast.makeText(MainActivity.this, "Data has been inserted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowData.class);
                startActivity(intent);
            }
        });


    }

    //----------------------------------------------
}