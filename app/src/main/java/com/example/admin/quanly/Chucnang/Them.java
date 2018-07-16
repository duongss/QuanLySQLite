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

public class Them extends AppCompatActivity {
    Button thembtn, backbtn;
    Data db;
    ArrayList<Sach>s =new ArrayList<>();
    EditText ten,mota,giatien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        thembtn = (Button) findViewById(R.id.btnOK);
        backbtn = (Button) findViewById(R.id.btnBack);
        ten=(EditText) findViewById(R.id.editTEN);
        mota=(EditText) findViewById(R.id.editMota);
        giatien=(EditText) findViewById(R.id.editGiatien);
        thembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sach sach = new Sach(ten.getText().toString(),
                        mota.getText().toString(),Integer.parseInt(giatien.getText().toString()));
                db = new Data(Them.this);
                db.addS(sach);
                Intent intent = new Intent(Them.this,MainActivity.class);
                startActivity(intent);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Them.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
