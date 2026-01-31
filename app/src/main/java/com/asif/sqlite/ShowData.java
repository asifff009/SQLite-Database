package com.asif.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowData extends AppCompatActivity {

    TextView tvDisplay;
    SearchView searchView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tvDisplay = findViewById(R.id.tvDisplay);
        searchView = findViewById(R.id.searchView);
        dbHelper = new DatabaseHelper(this);

        // App open hole shob data dekhabe
        showAllData();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchData(newText);
                return true;
            }
        });
    }

    private void showAllData() {
        tvDisplay.setText("");
        Cursor cursor = dbHelper.getAllData();

        if (cursor.getCount() == 0) {
            tvDisplay.setText("No data found");
            cursor.close();
            return;
        }

        while (cursor.moveToNext()) {
            tvDisplay.append(
                    "ID: " + cursor.getInt(0) +
                            " Name: " + cursor.getString(1) +
                            " Mobile: " + cursor.getString(2) + "\n"
            );
        }
        cursor.close();
    }

    private void searchData(String name) {
        tvDisplay.setText("");
        Cursor cursor = dbHelper.searchDataByName(name);

        if (cursor.getCount() == 0) {
            tvDisplay.setText("No match found");
            cursor.close();
            return;
        }

        while (cursor.moveToNext()) {
            tvDisplay.append(
                    "ID: " + cursor.getInt(0) +
                            " Name: " + cursor.getString(1) +
                            " Mobile: " + cursor.getString(2) + "\n"
            );
        }
        cursor.close();
    }
}
