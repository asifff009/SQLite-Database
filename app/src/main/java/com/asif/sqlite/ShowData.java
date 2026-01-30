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
        //tvDisplay.setText("Total Data = "+cursor.getCount());

        int x = 0;
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String mobile = cursor.getString(2); // 0,1,2 kon column sheita bujhay
            tvDisplay.append("ID : "+id+" Name : "+name+" Mobile : "+mobile+"\n");
        }

    }
}