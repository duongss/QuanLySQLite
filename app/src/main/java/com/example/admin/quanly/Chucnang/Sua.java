package com.example.admin.quanly.Chucnang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.quanly.Doituong.Sach;
import com.example.admin.quanly.Dulieu.Data;
import com.example.admin.quanly.MainActivity;
import com.example.admin.quanly.R;

import java.util.ArrayList;

public class Sua extends AppCompatActivity {
    Button thembtn, backbtn;
    Data db;
    ArrayList<Sach> s = new ArrayList<>();
    EditText tened, motaed, giatiened;
    int Id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        thembtn = (Button) findViewById(R.id.btnOK);
        backbtn = (Button) findViewById(R.id.btnBack);
        tened = (EditText) findViewById(R.id.editTEN);
        motaed = (EditText) findViewById(R.id.editMota);
        giatiened = (EditText) findViewById(R.id.editGiatien);
        Id =      getIntent().getIntExtra   ("cc", 0);
        final String ten =  getIntent().getStringExtra("cc1");
        final String mota = getIntent().getStringExtra("cc2");
        final int giatien = getIntent().getIntExtra   ("cc3", 0);
        tened.setText(ten);
        motaed.setText(mota);
        giatiened.setText(String.valueOf(giatien));
        thembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sach sach = new Sach(Id,tened.getText().toString(),motaed.getText().toString()
                        ,Integer.parseInt(giatiened.getText().toString()));
                db = new Data(Sua.this);
                db.update(sach);
                Intent intent = new Intent(Sua.this, MainActivity.class);
                startActivity(intent);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sua.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
