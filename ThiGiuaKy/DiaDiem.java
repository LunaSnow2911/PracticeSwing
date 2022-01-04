package ThiGiuaKy;

public class DiaDiem {
    private String maDD;
    private String ten;
    private String thanhPho_tinh;
    private String quan_huyen;
    private String phuong_xa;
    private String dc_ChiTiet;

    public DiaDiem(String maDD, String ten, String thanhPho_tinh, String quan_huyen, String phuong_xa,
            String dc_ChiTiet) {
        this.maDD = maDD;
        this.ten = ten;
        this.thanhPho_tinh = thanhPho_tinh;
        this.quan_huyen = quan_huyen;
        this.phuong_xa = phuong_xa;
        this.dc_ChiTiet = dc_ChiTiet;
    }

    @Override
    public String toString() {
        return "  Ma dia diem: " + maDD + "\n  Ten dia diem: " + ten + "\n  Thanh pho/Tinh: " + thanhPho_tinh
                + "\n  Quan/Huyen: " + quan_huyen + "\n  Dia chi chi tiet: " + dc_ChiTiet;
    }

    public String getThanhPho_tinh() {
        return thanhPho_tinh;
    }

    public String getQuan_huyen() {
        return quan_huyen;
    }

    public static void main(String[] args) {
        String id = "81000";
        String name = "Long An";
        String tp = "tpHCm";
        String qh = "CanDuoc";
        String px = "LHĐ";
        String address = "xa LHD, huyen Can Duoc, tinh Long An";

        DiaDiem dd = new DiaDiem(id, name, tp, qh, px, address);
        System.out.println(dd.toString());
    }
}
