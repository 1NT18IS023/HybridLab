package com.example.list_view_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
    String classmateslist[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = findViewById(R.id.list);
        classmateslist = getResources().getStringArray(R.array.classmates);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.textview_layout,classmateslist);
        mylist.setAdapter(arrayAdapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "you have clicked"+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();

            }
        });

    }

}