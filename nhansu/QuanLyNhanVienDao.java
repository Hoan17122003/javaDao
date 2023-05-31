package nhansu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import connection.GetConnection;
import daodb.DaoDB;

public class QuanLyNhanVienDao implements DaoDB<QuanLyNhanvien> {

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
        try {
            Connection con = new GetConnection().getConnection();
            String stmtInsert = """
                    insert into NhanVien values(?,?,?,?,?,?,?,?)
                    """;
            PreparedStatement pr = con.prepareStatement(stmtInsert);
            // if (checkKey(qlnv.getNhanvien().getID()))
            pr.setString(1, qlnv.getNhanvien().getID());
            pr.setString(2, qlnv.getNhanvien().getMaPhongBan());
            pr.setString(3, qlnv.getNhanvien().getName());
            pr.setDate(4, qlnv.getNhanvien().getDOB());
            pr.setString(5, qlnv.getNhanvien().getGender());
            pr.setDate(6, qlnv.getNhanvien().getNgayvaolam());
            pr.setString(7, qlnv.getNhanvien().getDiaChi());
            pr.setString(8, qlnv.getbangcap());
            pr.executeUpdate();
            System.out.println("insert conrrect!!!");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    public void display(QuanLyNhanVien qlnv, String valueSearch) throws SQLException {
        SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Connection conn = new GetConnection().getConnection();
            String stmtSelect = "Select * From NhanVien WHERE HoTen Like'" + valueSearch + "%'";
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

    @Override
    public void delete(String ID) throws SQLException {
        try {
            Connection con = new GetConnection().getConnection();
            String smtmDelete = """
                    delete
                    from NhanVien
                    WHERE MaNhanVien =
                    """ + ID;
            PreparedStatement pr = con.prepareStatement(smtmDelete);
            pr.executeUpdate();
            System.out.println("delete success");
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new SQLException("", ID, 0, e)
            // TODO: handle exception
        }
    }

    @Override
    public void save(QuanLyNhanVienDao qlnv) {
    }

    @Override
    public List<String> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void delete(QuanLyNhanvien item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void save(QuanLyNhanvien item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
