package com.hiepk14.bai1;

public class SinhVien {
    private int id;
    private String name, date, school;
    private int sex;
    private int bongda, bongro, bongchuyen;

    public SinhVien(int id, String name, String date, String school, int sex, int bongda, int bongro, int bongchuyen) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.school = school;
        this.sex = sex;
        this.bongda = bongda;
        this.bongro = bongro;
        this.bongchuyen = bongchuyen;
    }

    public SinhVien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getBongda() {
        return bongda;
    }

    public void setBongda(int bongda) {
        this.bongda = bongda;
    }

    public int getBongro() {
        return bongro;
    }

    public void setBongro(int bongro) {
        this.bongro = bongro;
    }

    public int getBongchuyen() {
        return bongchuyen;
    }

    public void setBongchuyen(int bongchuyen) {
        this.bongchuyen = bongchuyen;
    }
}
