package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
public class MainActivity2 extends AppCompatActivity {
    EditText name, phone, Delete;
    TextView info;
    myDbAdapter helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        Delete = findViewById(R.id.Delete);
        info = findViewById(R.id.info);

        helper = new myDbAdapter(this);

    }

    public void addUser(View view) {
        String t1 = name.getText().toString();
        String t2 = phone.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(this, "Enter Both Name & Phone number", Toast.LENGTH_SHORT).show();
        } else {
            long id = helper.insertData(t1, t2);
            if (id <= 0) {
                Toast.makeText(this, "Adding Fai,ld", Toast.LENGTH_SHORT).show();
                name.setText("");
                phone.setText("");

            } else {
                Toast.makeText(this, "Adding Successfull", Toast.LENGTH_SHORT).show();
                name.setText("");
                phone.setText("");

            }
        }
    }

    public void viewdata(View view) {
        String data = helper.getData();
        info.setText(data);
    }

    public void delete(View view) {
        String uname = Delete.getText().toString();
        if (uname.isEmpty()) {
            info.setText("Enter Data");
        } else {
            int a = helper.delete(uname);
            if (a <= 0) {
                info.setText("unsuccesssfull");
                Delete.setText("");
            } else {
               info.setText("successfull");
                Delete.setText("");
            }

        }
    }

}