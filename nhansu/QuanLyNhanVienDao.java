package nhansu;

import java.nio.channels.UnsupportedAddressTypeException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

import connection.GetConnection;
import daodb.DaoDB;

public class QuanLyNhanVienDao implements DaoDB<QuanLyNhanvien> {

    private QuanLyNhanVienDao qlnvDao = null;

    public QuanLyNhanVienDao getInstace() {
        if (qlnvDao == null) {
            qlnvDao = new QuanLyNhanVienDao();
        }
        return qlnvDao;
    }

    @Override
    public void update(QuanLyNhanvien qlnv) throws SQLException {
        try {
            Connection con = new GetConnection().getConnection();
            String stmtUpdate = """
                    update QuanLyNhanSu
                    set Luong = Luong + 150
                    where Luong < 1000
                    """;
            PreparedStatement pr = con.prepareStatement(stmtUpdate);
            pr.executeQuery();
            System.out.println("update success");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public boolean checkKey(String ID) throws SQLException {
        boolean flag = true;
        try {
            Connection con = new GetConnection().getConnection();
            String condition = """
                    select MaNhanVien
                    from NhanVien
                    Where MaNhanVien =
                    """ + ID;
            PreparedStatement pr = con.prepareStatement(condition);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                flag = false;

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return flag;
    }

    @Override
    public void insert(QuanLyNhanvien qlnv) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = new GetConnection().getConnection();
            String stmtInsert = """
                    insert into NhanVien values(?,?,?,?,?,?,?,?)
                    """;
            PreparedStatement pr = con.prepareStatement(stmtInsert);
            for (int i = 0; i < qlnv.getContainNhanVien().size(); i++) {

                while (checkKey((qlnv.getContainNhanVien().get(i).getID()))
                        || (checkPhongBan(qlnv.getContainNhanVien().get(i).getID())
                                && checkKey((qlnv.getContainNhanVien().get(i).getID())))) {
                    qlnv.getContainNhanVien().get(i).setID(sc.nextLine());
                }
            }
            for (int i = 0; i < qlnv.getContainNhanVien().size(); i++) {
                pr.setString(1, qlnv.getContainNhanVien().get(i).getID());
                pr.setString(2, qlnv.getContainNhanVien().get(i).getMaPhongBan());
                pr.setString(3, qlnv.getContainNhanVien().get(i).getName());
                pr.setDate(4, qlnv.getContainNhanVien().get(i).getDOB());
                pr.setString(5, qlnv.getContainNhanVien().get(i).getGender());
                pr.setDate(6, qlnv.getContainNhanVien().get(i).getNgayvaolam());
                pr.setString(7, qlnv.getContainNhanVien().get(i).getDiaChi());
                pr.setString(8, qlnv.getContainNhanVien().get(i).getbangcap());
                pr.executeUpdate();
            }
            System.out.println("insert conrrect!!!");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        sc.close();
    }

    @Override
    public void display(String valueSearch) throws SQLException {
        SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Connection conn = new GetConnection().getConnection();
            String stmtSelect = "Select * From NhanVien WHERE HoTen = '" + valueSearch + "'";
            PreparedStatement pr = conn.prepareStatement(stmtSelect);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
                        + smp.format(rs.getDate(4)) + " " + rs.getString(5) + " " + smp.format(rs.getDate(6)) + " "
                        + rs.getString(7) + " "
                        + rs.getString(8));
            }
            conn.close();
            System.out.println("done query");
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    public static boolean checkNumber(Character value) {
        String temp = value.toString();
        return Pattern.matches("[0-9]", temp);

    }

    @Override
    public void delete(String ID) throws SQLException {
        try {

            Connection con = new GetConnection().getConnection();
            String smtmDelete = """
                    delete
                    from NhanVien
                    WHERE HoTen =
                    """ + ID;
            PreparedStatement pr = con.prepareStatement(smtmDelete);
            pr.executeUpdate();
            con.close();
            System.out.println("delete success");
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new SQLException("", ID, 0, e)
            // TODO: handle exception
        }
    }

    public boolean checkPhongBan(String MaNhanVien) throws SQLException {
        boolean flag = false;
        try {
            String temp;
            for (int i = 0; i < MaNhanVien.length(); i++) {
                if (!checkNumber(MaNhanVien.charAt(i))) {
                    temp = MaNhanVien.substring(0, i);
                    break;
                }
            }
            Connection con = new GetConnection().getConnection();
            String smtmCheck = """
                    select *
                    from PhongBan
                    where MaPhongBan =
                        """ + MaNhanVien;
            PreparedStatement pr = con.prepareStatement(smtmCheck);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return flag;
    }

    @Override
    public void save(QuanLyNhanVienDao qlnv) {
        throw new UnsupportedAddressTypeException("continue");
    }

    @Override
    public List<String> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void save(QuanLyNhanvien item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
