package com.asif.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowData extends AppCompatActivity {

    TextView tvDisplay;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tvDisplay = findViewById(R.id.tvDisplay);
        dbHelper = new DatabaseHelper(ShowData.this);

        Cursor cursor = dbHelper.getAllData(); //shob data ekhon cursor er moddhe chole ashche
        tvDisplay.setText("Total Data= "+cursor.getCount());

    }
}