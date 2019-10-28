package com.example.subjectessay;

import java.util.ArrayList;

public class Patient {
    private int maBenhNhan;
    private String tenBenhNhan;
    private String matKhau;
    private ArrayList<Schedule> lichThuoc;

    public Patient(int maBenhNhan, String tenBenhNhan, String matKhau, ArrayList<Schedule> lichThuoc) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.matKhau = matKhau;
        this.lichThuoc = lichThuoc;
    }

    public Patient(int maBenhNhan, String tenBenhNhan, String matKhau) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.matKhau = matKhau;
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public ArrayList<Schedule> getLichThuoc() {
        return lichThuoc;
    }

    public void setLichThuoc(ArrayList<Schedule> lichThuoc) {
        this.lichThuoc = lichThuoc;
    }
}
