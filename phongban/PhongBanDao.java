package phongban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import connection.GetConnection;
import daodb.DaoDB;

public class PhongBanDao implements DaoDB<PhongBan> {

    public PhongBanDao() {
    }

    @Override
    public void insert(PhongBan pb) throws SQLException {
        try {
            Connection con = new GetConnection().getConnection();
            String stmtInsert = """
                    insert into PhongBan values(?,?)
                    """;
            PreparedStatement pr = con.prepareStatement(stmtInsert);
            pr.setString(1, pb.getID());
            pr.setString(2, pb.getTenPB());
            pr.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public void delete(String valueDelete) throws SQLException {
        try {
            System.out.println("check 1");
            Connection con = new GetConnection().getConnection();
            String stmtDelete = """
                        delete
                        from PhongBan
                        where MaPhongBan =
                    """ + "'" + valueDelete + "'";
            PreparedStatement pr = con.prepareStatement(stmtDelete);
            pr.executeUpdate();
            System.out.println("check 2");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    public void display(String valueSearch) throws SQLException {
        try {
            Connection con = new GetConnection().getConnection();
            String stmtSelect = """
                    select *
                    from PhongBan
                    """;
            PreparedStatement pr = con.prepareStatement(stmtSelect);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    rs.getString(i);
                }
            }
            con.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
