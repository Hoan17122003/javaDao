package main;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture.AsynchronousCompletionTask;

import nhansu.*;

public class Main extends Thread implements Runnable {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanvien qlnv = QuanLyNhanvien.getInstace();
        Nhanvien nv = new Nhanvien();
        nv.input();
        qlnv.add(nv);
        QuanLyNhanVienDao qd = new QuanLyNhanVienDao();
        try {
            // qd.insert(qlnv);
            // qd.display(qlnv, sc.nextLine());
            qd.delete(sc.nextLine());

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        sc.close();
    }

}
