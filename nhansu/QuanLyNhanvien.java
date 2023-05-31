package nhansu;

import daodb.DaoDB;

public class QuanLyNhanvien extends Nhanvien {
    private static QuanLyNhanvien quanly;
    private static Nhanvien nhanvien;
    private static float luong;
    private static QuanLyNhanVienDao quanlynhanviendao;

    public static QuanLyNhanvien getInstace() {
        if (quanly == null) {
            quanly = new QuanLyNhanvien();
        }
        return quanly;
    }

    public Nhanvien getNhanvien() {
        return this.nhanvien;
    }

    public float getLuong() {
        if (nhanvien.getSoNamLamViec() >= 1)
            this.luong += luong * 1.5;
        return this.luong;
    }

    public void add(Nhanvien nv) {
        int luongcung = 1000;
        this.nhanvien = nv;
        if (this.nhanvien.getbangcap() == "ki su") {
            this.luong = (float) (luongcung * 1.5);
        }
        this.luong = luongcung * 1.f;
    }

}