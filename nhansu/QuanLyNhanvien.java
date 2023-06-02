package nhansu;

import java.util.ArrayList;

import daodb.DaoDB;

public class QuanLyNhanvien {
    private static QuanLyNhanvien quanly;
    private static ArrayList<Nhanvien> containNhanVien;
    private static ArrayList<Float> containLuongNhanVien;

    public static QuanLyNhanvien getInstace() {
        if (quanly == null) {
            quanly = new QuanLyNhanvien();
        }
        return quanly;
    }

    public ArrayList<Float> getContainLuongNhanVien() {
        return this.containLuongNhanVien;
    }

    public ArrayList<Nhanvien> getContainNhanVien() {
        return this.containNhanVien;
    }

    public void add(Nhanvien nv) {
        int luongcung = 1000;
        containNhanVien.add(nv);
        for (int i = 0; i < containNhanVien.size(); i++) {
            if (containNhanVien.get(i).getbangcap() == "ki su") {
                containLuongNhanVien.add((float) (luongcung * 1.5 * 1.f));
            }
        }
        // this.luong = luongcung * 1.f;
    }

}