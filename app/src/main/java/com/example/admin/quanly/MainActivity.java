package com.example.admin.quanly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.admin.quanly.Chucnang.AdapterList1;
import com.example.admin.quanly.Chucnang.Sua;
import com.example.admin.quanly.Chucnang.Them;
import com.example.admin.quanly.Doituong.Sach;
import com.example.admin.quanly.Dulieu.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Sach> arrayList1;
    AdapterList1 adapterList1;
    Button btnsua, btnthem;
    Data db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Data(this);
        list = (ListView) findViewById(R.id.list1);
        btnthem = (Button) findViewById(R.id.btnthem);
        Cauhinhlist();
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int Id = arrayList1.get(position).getId();
                Sach sach = new Sach(Id);
                db.delete(sach);
                arrayList1.remove(position);
                adapterList1.notifyDataSetChanged();
                return false;
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Them.class);
                startActivity(intent);
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int Id = arrayList1.get(position).getId();
                String ten = arrayList1.get(position).getTensach();
                String mota = arrayList1.get(position).getMota();
                int giatien = arrayList1.get(position).getGiatien();
                Intent intent = new Intent(MainActivity.this, Sua.class);
                intent.putExtra("cc", Id);
                intent.putExtra("cc1", ten);
                intent.putExtra("cc2", mota);
                intent.putExtra("cc3", giatien);
                startActivity(intent);
            }
        });
    }

    private void Cauhinhlist() {
        arrayList1 = db.getAll();
        adapterList1 = new AdapterList1(getLayoutInflater(), arrayList1);
        list.setAdapter(adapterList1);
    }


}
