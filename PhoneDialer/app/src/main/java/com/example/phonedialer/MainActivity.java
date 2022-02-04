package com.example.phonedialer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNo;

    Button callBtn, savebtn;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNo = findViewById(R.id.phoneNumber);
        callBtn = findViewById(R.id.btnCall);
        savebtn = findViewById(R.id.btnSave);

        // runtime check to see ifn call perm is granted. not needed for ACTION_DIAL
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Call permission granted", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }

    public void callEvent(View view) {
        String number = phoneNo.getText().toString();

        if (number != "" || number != null) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Enter a number first", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveEvent(View view) {
        String number = phoneNo.getText().toString();
        if (number != "" || number != null) {
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
//            intent.putExtra(ContactsContract.Intents.Insert.NAME, "");
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, number);
//            intent.putExtra(ContactsContract.Intents.Insert.EMAIL, "");
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Enter a number first", Toast.LENGTH_SHORT).show();
        }
    }
}