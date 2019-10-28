package com.example.subjectessay;

import java.util.Date;

public class Schedule {
    private int id;
    private String tenThuoc;
    private Date thoiGian;
    private String ghiChu;

    public Schedule(int id, String tenThuoc, Date thoiGian, String ghiChu) {
        this.id = id;
        this.tenThuoc = tenThuoc;
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
    }

    public Schedule(int id, String tenThuoc,  String ghiChu) {
        this.id = id;
        this.tenThuoc = tenThuoc;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
