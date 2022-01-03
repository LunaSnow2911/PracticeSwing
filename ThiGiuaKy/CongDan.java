package ThiGiuaKy;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class CongDan {
    private String maCD;
    private String hoTen;
    private String maCCCD_CMND;
    private String maBHYT;
    private int namSinh;
    private String queQuan;
    private DiaDiem diaChiTT;
    private LinkedList<MuiTiem> dsTiemChung;
    private LinkedList<NhiemCovid> dsLanNhiemCovid;

    public CongDan(String maCD, String hoTen, String maCCCD_CMND, String maBHYT, int namSinh, String queQuan,
            DiaDiem diaChiTT, LinkedList<MuiTiem> dsTiemChung, LinkedList<NhiemCovid> dsLanNhiemCovid) {
        this.maCD = maCD;
        this.hoTen = hoTen;
        this.maCCCD_CMND = maCCCD_CMND;
        this.maBHYT = maBHYT;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.diaChiTT = diaChiTT;
        this.dsTiemChung = dsTiemChung;
        this.dsLanNhiemCovid = dsLanNhiemCovid;
    }

    @Override
    public String toString() {
        return "-Ma Cong dan: " + maCD + "\n-Ho va ten: " + hoTen + "\n-CCCD/CMND: " + maCCCD_CMND
                + "\n-Ma BHYT" + maBHYT + "\n-Nam sinh: " + namSinh + "\n-Que quan: " + queQuan
                + "\n-Dia chi Thuong tru:\n" + diaChiTT + "\n-Danh sach tiem chung:\n" + dsTiemChung
                + "\n-Danh sach lan nhiem Covid: \n" + dsLanNhiemCovid;
    }

    public LinkedList<MuiTiem> getDsTiemChung() {
        return dsTiemChung;
    }

    public LinkedList<NhiemCovid> getDsLanNhiemCovid() {
        return dsLanNhiemCovid;
    }

    public int getSoMuiTiem() {
        return dsTiemChung.size();
    }

    public void addDsTiemChung(MuiTiem m) {
        dsTiemChung.addLast(m);
    }

    public void addLanNhiemCovid(NhiemCovid n) {
        dsLanNhiemCovid.add(n);
    }

    public Date convertToDate(String sDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date resultDate = sdf.parse(sDate);

        return resultDate;

    }

    public boolean da_tung_nhiemCovid() {
        return dsLanNhiemCovid.size() > 0 ? true : false;
    }

    public boolean coNhiemCovid(String ngay) {
        boolean result = false;
        for (NhiemCovid temp : dsLanNhiemCovid) {
            try {
                Date begin = convertToDate(temp.getNgayBDCachLy());
                Date end = convertToDate(temp.getNgayKTCachLy());
                Date dateInput = convertToDate(ngay);
                result = (begin.before(dateInput) && dateInput.before(end)) ? true : false;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }

    public DiaDiem getDiaChiTT() {
        return diaChiTT;
    }

    public static void main(String[] args) {
        String id = "81000";
        String name = "Long An";
        String tp = "tpHCm";
        String qh = "CanDuoc";
        String px = "LHĐ";
        String address = "xa LHD, huyen Can Duoc, tinh Long An";
        DiaDiem diaChiTT = new DiaDiem(id, name, tp, qh, px, address);

        String ngay1 = "22/7/2021";
        String ngay2 = "22/8/2021";
        DiaDiem dd = new DiaDiem(id, name, tp, qh, px, address);
        String tenVacxin = "Astrazeneca";
        String loVacxin1 = "Lo 1";
        String loVacxin2 = "Lo 2";

        MuiTiem muiTiem1 = new MuiTiem(ngay1, dd, tenVacxin, loVacxin1);
        MuiTiem muiTiem2 = new MuiTiem(ngay2, dd, tenVacxin, loVacxin2);

        LinkedList<MuiTiem> dsTiem = new LinkedList<>();
        dsTiem.addLast(muiTiem1);
        // dsTiem.add(muiTiem2);

        String maBN = "666";
        String start = "10/10/2021";
        String end = "24/10/2021";

        String maBN2 = "999";
        String start2 = "10/12/2021";
        String end2 = "24/12/2021";

        NhiemCovid lan1 = new NhiemCovid(maBN, start, end);
        NhiemCovid lan2 = new NhiemCovid(maBN2, start2, end2);

        LinkedList<NhiemCovid> dsLanNhiemCovid = new LinkedList<>();
        LinkedList<NhiemCovid> dsLanNhiemCovid2 = new LinkedList<>();
        dsLanNhiemCovid.addLast(lan1);
        // dsLanNhiemCovid.add(lan2);

        String maCD = "20130068";
        String hoTen = "DAO LUU TRONG LUAN";
        String CCCD = "CCCD-20130068";
        String maBHYT = "BHYT-20130068";
        int namSinh = 2002;
        String queQuan = "Long An";

        CongDan congdan1 = new CongDan(maCD, hoTen, CCCD, maBHYT, namSinh, queQuan, diaChiTT, dsTiem, dsLanNhiemCovid);

        System.out.println(congdan1.toString());

        System.out.println(congdan1.getSoMuiTiem());
        congdan1.addDsTiemChung(muiTiem2);
        System.out.println(congdan1.getSoMuiTiem());
        System.out.println(congdan1.getDsTiemChung());

        System.out.println(congdan1.getDsLanNhiemCovid());
        congdan1.addLanNhiemCovid(lan2);
        System.out.println(congdan1);

        System.out.println("Co nhiem covid trong ngay 15/10/2021? " +
                congdan1.coNhiemCovid("15/10/2021"));
        System.out.println("Co nhiem covid trong ngay 1/12/2021? " +
                congdan1.coNhiemCovid("1/12/2021"));

        System.out.println(dsLanNhiemCovid);

    }

}
