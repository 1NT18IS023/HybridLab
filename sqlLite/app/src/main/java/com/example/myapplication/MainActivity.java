package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView EmpName = findViewById(R.id.name);
        TextView EmpDept= findViewById(R.id.dept);
        EditText EmpAge = findViewById(R.id.age);
        EditText EmpPh = findViewById(R.id.phone);

        Button submitBtn = findViewById(R.id.submit);

        DatabaseHelper dbh = new DatabaseHelper(getApplicationContext());

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee emp = new Employee(EmpName.getText().toString(),
                        EmpDept.getText().toString(),
                        (EmpAge.getText().toString()),
                        (EmpPh.getText().toString())
                );

                if (dbh.InsertEmployee(emp)) {
                    Toast.makeText(getApplicationContext(), "Record inserted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Record not inserted", Toast.LENGTH_SHORT).show();
                }

                EmpName.setText("");
                EmpDept.setText("");
                EmpAge.setText("");
                EmpPh.setText("");
            }
        });
    }
}