package com.example.admin.quanly.Chucnang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.admin.quanly.Doituong.Sach;
import com.example.admin.quanly.R;
import java.util.ArrayList;

public class AdapterList1 extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Sach> lists;
    TextView ten;
    TextView mota;
    TextView giatien;
    public AdapterList1(LayoutInflater layoutInflater, ArrayList<Sach> lists) {
        this.layoutInflater = layoutInflater;
        this.lists = lists;
    }
    @Override
    public int getCount() {
        return lists.size();
    }
    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapterlist, null);
        }
        Sach s = lists.get(position);
        ten = (TextView) convertView.findViewById(R.id.tentxt);
        mota = (TextView) convertView.findViewById(R.id.motatxt);
        giatien = (TextView) convertView.findViewById(R.id.giatientxt);
        ten.setText("TÊN:"+s.getTensach());
        mota.setText("MÔ TẢ:"+s.getMota());
        giatien.setText("GIÁ TIỀN:"+String.valueOf(s.getGiatien()));
        return convertView;
    }
}
