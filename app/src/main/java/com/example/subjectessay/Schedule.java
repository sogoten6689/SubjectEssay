package com.example.subjectessay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Schedule {
    private int id;
    private String tenThuoc;
    private Date ngay;
    private Date gio;
    private String ghiChu;


    public Schedule(int id, String tenThuoc, Date gio, Date ngay, String ghiChu) {
        this.id = id;
        this.tenThuoc = tenThuoc;
        this.ngay = ngay;
        this.gio = gio;
        this.ghiChu = ghiChu;
    }

    public Schedule(int id, String tenThuoc,  String ghiChu) {
        this.id = id;
        this.tenThuoc = tenThuoc;
        this.ghiChu = ghiChu;
    }


    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
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

    public Date getGio() {
        return gio;
    }

    public void setGio(Date gio) {
        this.gio = gio;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * lấy định dạng ngày
     * @param d
     * @return
     */
    public String getDateFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }

    /**
     * lấy định dạng giờ phút
     * @param d
     * @return
     */
    public String getHourFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("hh:mm a", Locale.getDefault());
        return dft.format(d);
    }

}
