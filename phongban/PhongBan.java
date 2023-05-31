package phongban;

public class PhongBan {
    private static String ID;
    private static String TenPB;

    public PhongBan() {
    }

    public PhongBan(String ID, String TenPB) {
        this.ID = ID;
        this.TenPB = TenPB;
    }

    public static void setID(String iD) {
        ID = iD;
    }

    public static void setTenPB(String tenPB) {
        TenPB = tenPB;
    }

    public static String getID() {
        return ID;
    }

    public static String getTenPB() {
        return TenPB;
    }

}
