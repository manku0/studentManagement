package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.id);
        password = findViewById(R.id.Password);

        Environment.getExternalStorageDirectory();
    }

    public void openActivity(View view) {
        String t1 = id.getText().toString();
        String t2 = password.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter both user Id  &  Password", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);

        }
    }
}