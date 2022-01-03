package ThiGiuaKy;

import java.util.StringTokenizer;

public class MuiTiem {
    private String ngay;
    private DiaDiem diaDiem;
    private String tenVacxin;
    private String loVacxin;

    public MuiTiem(String ngay, DiaDiem diaDiem, String tenVacxin, String loVacxin) {
        this.ngay = ngay;
        this.diaDiem = diaDiem;
        this.tenVacxin = tenVacxin;
        this.loVacxin = loVacxin;
    }

    @Override
    public String toString() {
        return " Ngay tiem: " + ngay + "\n Dia diem tiem:\n" + diaDiem
                + "\n Ten vacxin: " + tenVacxin + "\n Lo Vacxin: " + loVacxin + "\n";
    }

    public static void main(String[] args) {

        String id = "123abc";
        String name = "VietNam";
        String tp = "tpHCm";
        String qh = "CanDuoc";
        String px = "LHĐ";
        String address = "xa LHD, huyen Can Duoc, tinh Long An";

        String ngay = "22/10/2021";
        DiaDiem dd = new DiaDiem(id, name, tp, qh, px, address);
        String tenVacxin = "Astrazeneca";
        String loVacxin = "Lo 1";

        MuiTiem muiTiem = new MuiTiem(ngay, dd, tenVacxin, loVacxin);
        System.out.println(muiTiem.toString());
    }
}
