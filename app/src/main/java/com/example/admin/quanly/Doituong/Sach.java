package com.example.admin.quanly.Doituong;

public class Sach {
    int Id;
    String tensach;
    String mota;
    int giatien;

    public Sach(String tensach, String mota, int giatien) {
        this.tensach = tensach;
        this.mota = mota;
        this.giatien = giatien;
    }

    public Sach(int id, String tensach, String mota, int giatien) {
        Id = id;
        this.tensach = tensach;
        this.mota = mota;
        this.giatien = giatien;
    }

    public Sach(int id) {
        Id = id;
    }

    public Sach()
{}
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }
}
