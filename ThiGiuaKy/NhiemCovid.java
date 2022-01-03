package ThiGiuaKy;

public class NhiemCovid {
    private String maBN;
    private String ngayBDCachLy;
    private String ngayKTCachLy;

    public NhiemCovid(String maBN, String ngayBDCachLy, String ngayKTCachLy) {
        this.maBN = maBN;
        this.ngayBDCachLy = ngayBDCachLy;
        this.ngayKTCachLy = ngayKTCachLy;
    }

    @Override
    public String toString() {
        return " Ma Benh nhan: " + maBN + "\n Ngay bat dau cach ly: " + ngayBDCachLy
                + "\n Ngay ket thuc cach ly: " + ngayKTCachLy + "\n";
    }

    public String getNgayBDCachLy() {
        return ngayBDCachLy;
    }

    public String getNgayKTCachLy() {
        return ngayKTCachLy;
    }

    public static void main(String[] args) {
        String id = "12asd";
        String start = "20/3";
        String end = "27/3";

        NhiemCovid test = new NhiemCovid(id, start, end);
        System.out.println(test);
    }
}
