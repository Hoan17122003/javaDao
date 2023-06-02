package main;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture.AsynchronousCompletionTask;

import nhansu.*;
import phongban.PhongBanDao;

public class Main extends Thread implements Runnable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanvien qlnv = QuanLyNhanvien.getInstace();
        // Nhanvien nv = new Nhanvien();
        // nv.input();
        // qlnv.add(nv);
        QuanLyNhanVienDao qd = new QuanLyNhanVienDao();
        PhongBanDao pbd = new PhongBanDao();
        try {
            // qd.insert(qlnv);
            String valueSearch = sc.nextLine();
            qd.display(valueSearch);
            // System.out.println("nhap ten can xoa");
            // pbd.delete(sc.nextLine());
            // qd.delete(sc.nextLine());

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        sc.close();
    }

}
