package com.example.crudop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    EditText name,contact,age;
    DBHelper DB;
    Button insert,update,delete,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        age = findViewById(R.id.age);
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);
        DB = new DBHelper(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String ageTXT = age.getText().toString();
                boolean qryStatus = DB.insertData(nameTXT,contactTXT,ageTXT);
                if (qryStatus==true)
                    Toast.makeText(MainActivity.this, "New Record Created", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Record Creation Failed", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String ageTXT = age.getText().toString();
                boolean qryStatus = DB.updateData(nameTXT,contactTXT,ageTXT);
                if (qryStatus==true)
                    Toast.makeText(MainActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Record Updation Failed", Toast.LENGTH_SHORT).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String nameTXT = name.getText().toString();

                boolean qryStatus = DB.deleteData(nameTXT);
                if (qryStatus==true)
                    Toast.makeText(MainActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Record Deletion Failed", Toast.LENGTH_SHORT).show();

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.viewData();
                if(res.getCount()==0)
                    Toast.makeText(MainActivity.this, "No Record Exist", Toast.LENGTH_SHORT).show();
                else {
                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("Name :"+res.getString(0)+"\n");
                        buffer.append("Contact :"+res.getString(1)+"\n");
                        buffer.append("Age :"+res.getString(2)+"\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Data");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });
    }



}