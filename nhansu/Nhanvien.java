package nhansu;

import java.util.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nhanvien {
    private static String ID;
    private static String name;
    private static String DOB;
    private static String gender;
    private static String ngayvaolam;
    private static String DiaChi;
    private static String bangcap;
    private static String MaPhongBan;

    public Nhanvien() {
    }

    public Nhanvien(String ID, String MaPhongBan, String bangcap, String DiaChi, String name, String DOB, String gender,
            String ngayvaolam) {
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
        this.ngayvaolam = ngayvaolam;
        this.ID = ID;
        this.DiaChi = DiaChi;
        this.bangcap = bangcap;
        this.MaPhongBan = MaPhongBan;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ID: ");
        this.ID = sc.nextLine();
        System.out.println("Nhap Ten ");
        this.name = sc.nextLine();
        System.out.println("nhap Ngay Sinh : yyyy-MM-dd");
        this.DOB = sc.nextLine();
        System.out.println("nhap gioi tinh:");
        this.gender = sc.nextLine();
        System.out.println("Nhap ngay vao lam: yyyy-MM-dd");
        this.ngayvaolam = sc.nextLine();
        System.out.println("nhap Dia chi: ");
        this.DiaChi = sc.nextLine();
        System.out.println("Nhap Bang cap: ");
        this.bangcap = sc.nextLine();
        System.out.println("Nhap ma Phong ban");
        this.MaPhongBan = sc.nextLine();
    }

    public static void setMaPhongBan(String maPhongBan) {
        MaPhongBan = maPhongBan;
    }

    public static String getMaPhongBan() {
        return MaPhongBan;
    }

    public static void setbangcap(String bangcap) {
        bangcap = bangcap;
    }

    public static String getbangcap() {
        return bangcap;
    }

    public static void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public static String getDiaChi() {
        return DiaChi;
    }

    public static void setID(String iD) {
        ID = iD;
    }

    public static String getID() {
        return ID;
    }

    public static void setName(String name) {
        Nhanvien.name = name;
    }

    public static void setDOB(String dOB) {
        DOB = dOB;
    }

    public static void setGender(String gender) {
        Nhanvien.gender = gender;
    }

    public static void setNgayvaolam(String ngayvaolam) {
        Nhanvien.ngayvaolam = ngayvaolam;
    }

    public static Date getDOB() {
        return Date.valueOf(DOB);
    }

    public static String getGender() {
        return gender;
    }

    public static String getName() {
        return name;
    }

    public static Date getNgayvaolam() {
        return Date.valueOf(ngayvaolam);
    }

    public static float getSoNamLamViec() {
        LocalDate temp = LocalDate.parse(DOB, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return (float) ((temp.getMonthValue() / 12) + temp.getYear()) * 1.00f;
    }
}
