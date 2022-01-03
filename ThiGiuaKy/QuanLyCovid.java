package ThiGiuaKy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Map.Entry;

public class QuanLyCovid {

    private ArrayList<CongDan> dsCongDan = new ArrayList<>();

    public QuanLyCovid(ArrayList<CongDan> dsCongDan) {
        this.dsCongDan = dsCongDan;
    }

    public HashMap<String, Integer> tiemChung_tinh_TP(String tinh_tp, int soMui) {
        HashMap<String, Integer> result = new HashMap<>();
        for (CongDan tempCongDan : dsCongDan) {
            int tempSoMui = tempCongDan.getSoMuiTiem();

            String tempTinh_tp = tempCongDan.getDiaChiTT().getThanhPho_tinh();
            if (tempTinh_tp.equals(tinh_tp) && tempSoMui == soMui) {
                if (result.containsKey(tempTinh_tp)) {
                    result.put(tempTinh_tp, result.get(tempTinh_tp) + 1);
                } else {
                    result.put(tempTinh_tp, 1);
                }
            }
        }

        return result;
    }

    public int caNhiem_tinh_tp(String tinh_tp, String ngay) {
        int result = 0;
        for (CongDan tempCongDan : dsCongDan) {
            String tempTp = tempCongDan.getDiaChiTT().getThanhPho_tinh();
            LinkedList<NhiemCovid> tempCovids = tempCongDan.getDsLanNhiemCovid();
            for (NhiemCovid nhiemCovid : tempCovids) {
                if (nhiemCovid.getNgayBDCachLy().equals(ngay) && tempTp.equals(tinh_tp)) {
                    result++;
                }
            }
        }
        return result;
    }

    public HashMap<String, Integer> get_tinh_tp_caNhiem(String ngay) {
        HashMap<String, Integer> result = new HashMap<>();
        for (CongDan tempCongDan : dsCongDan) {
            String tempTp = tempCongDan.getDiaChiTT().getThanhPho_tinh();
            LinkedList<NhiemCovid> tempCovids = tempCongDan.getDsLanNhiemCovid();
            for (NhiemCovid nhiemCovid : tempCovids) {
                if (nhiemCovid.getNgayBDCachLy().equals(ngay)) {
                    int num = caNhiem_tinh_tp(tempTp, ngay);
                    result.put(tempTp, num);
                }
            }
        }

        return result;
    }

    public TreeMap<String, Integer> getSL_TungNhiemCovid() {
        TreeMap<String, Integer> result = new TreeMap<>();

        for (CongDan tempCongDan : dsCongDan) {
            String tempTp = tempCongDan.getDiaChiTT().getThanhPho_tinh();
            if (tempCongDan.da_tung_nhiemCovid()) {
                if (result.containsKey(tempTp)) {
                    result.put(tempTp, result.get(tempTp) + 1);
                } else {
                    result.put(tempTp, 1);
                }
            }
        }

        return result;
    }

    public String get_tinh_tp_Max_caNhiem(String ngay) {
        String result = "";
        HashMap<String, Integer> list = get_tinh_tp_caNhiem(ngay);
        int maxValue = 0;
        for (int value : list.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        for (String key : list.keySet()) {
            if (list.get(key) == maxValue) {
                result += key;
            }
        }
        return result;
    }

    public HashMap<String, Integer> tk_tiemChung_tinh_tp(int soMui) {
        HashMap<String, Integer> result = new HashMap<>();
        for (CongDan tempCongDan : dsCongDan) {
            int tempSoMui = tempCongDan.getSoMuiTiem();
            String tempTinh_tp = tempCongDan.getDiaChiTT().getThanhPho_tinh();
            if (tempSoMui == soMui) {
                if (result.containsKey(tempTinh_tp)) {
                    result.put(tempTinh_tp, result.get(tempTinh_tp) + 1);
                } else {
                    result.put(tempTinh_tp, 1);
                }
            }
        }

        return result;
    }

    public static <K, V extends Comparable<V>> Map<K, V> valueSort(final Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    public TreeMap<String, Integer> reverseTreeMap(TreeMap<String, Integer> treeMap) {
        TreeMap<String, Integer> result = new TreeMap<>();
        LinkedList<String> lk = new LinkedList<>();
        for (Entry<String, Integer> iEntry : treeMap.entrySet()) {
            lk.addFirst(iEntry.getKey());
        }
        for (String iString : lk) {
            result.put(iString, treeMap.get(iString));
        }

        return result;
    }

    public TreeMap<String, Integer> tk_caNhiem_tinh_tp_DESC() {
        TreeMap<String, Integer> temp = getSL_TungNhiemCovid();
        QuanLyCovid.valueSort(temp);
        TreeMap<String, Integer> result = reverseTreeMap(temp);

        return result;

    }

    @Override
    public String toString() {
        String result = "DANH SACH CONG DAN: \n";

        for (CongDan cd : dsCongDan) {
            result += cd.toString() + "\n";
        }

        return result;
    }

    public static void main(String[] args) {
        String id = "81000";
        String name = "Long An";
        String name2 = "Tien Giang";
        String name3 = "Ben Tre";
        String name4 = "An Giang";

        String tp = name;
        String qh = "CanDuoc";
        String tp2 = name2;
        String tp3 = name3;
        String tp4 = name4;
        String px = "LHĐ";
        String address = "xa LHD, huyen Can Duoc, tinh Long An";
        DiaDiem diaChiTT1 = new DiaDiem(id, name, tp, qh, px, address);
        DiaDiem diaChiTT2 = new DiaDiem(id, name2, tp2, qh, px, address);
        DiaDiem diaChiTT3 = new DiaDiem(id, name3, tp3, qh, px, address);
        DiaDiem diaChiTT4 = new DiaDiem(id, name4, tp4, qh, px, address);

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
        dsTiem.add(muiTiem2);

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
        LinkedList<NhiemCovid> dsLanNhiemCovid3 = new LinkedList<>();
        LinkedList<NhiemCovid> dsLanNhiemCovid4 = new LinkedList<>();
        dsLanNhiemCovid.addLast(lan1);
        dsLanNhiemCovid.add(lan2);
        dsLanNhiemCovid2.addLast(lan1);
        dsLanNhiemCovid2.add(lan2);
        dsLanNhiemCovid3.addLast(lan1);
        dsLanNhiemCovid3.add(lan2);
        dsLanNhiemCovid4.addLast(lan1);
        dsLanNhiemCovid4.add(lan2);

        String maCD = "20130068";
        String hoTen = "DAO LUU TRONG LUAN";
        String hoTen2 = "NGUYEN VAN A";
        String hotenString = "NGUYEN VAN B";
        String hotenString2 = "NGUYEN VAN C";
        String CCCD = "CCCD-20130068";
        String maBHYT = "BHYT-20130068";
        int namSinh = 2002;
        String queQuan = "Long An";
        String queQuan2 = "Tien Giang";
        String queQuan3 = "Ben Tre";
        String queQuan4 = "An Giang";

        CongDan congdan1 = new CongDan(maCD, hoTen, CCCD, maBHYT, namSinh, queQuan, diaChiTT1, dsTiem, dsLanNhiemCovid);
        CongDan congdan2 = new CongDan(maCD, hoTen2, CCCD, maBHYT, namSinh, queQuan2, diaChiTT2, dsTiem,
                dsLanNhiemCovid2);
        CongDan congdan3 = new CongDan(maCD, hotenString, CCCD, maBHYT, namSinh, queQuan3, diaChiTT3, dsTiem,
                dsLanNhiemCovid3);
        CongDan congdan4 = new CongDan(maCD, hotenString2, CCCD, maBHYT, namSinh, queQuan4, diaChiTT4, dsTiem,
                dsLanNhiemCovid4);
        CongDan congdan5 = new CongDan(maCD, hotenString2, CCCD, maBHYT, namSinh, queQuan4, diaChiTT4, dsTiem,
                dsLanNhiemCovid4);

        ArrayList<CongDan> listCongDan = new ArrayList<>();
        listCongDan.add(congdan1);
        listCongDan.add(congdan2);
        listCongDan.add(congdan3);
        listCongDan.add(congdan4);
        listCongDan.add(congdan5);

        QuanLyCovid quanLyCovid = new QuanLyCovid(listCongDan);

        System.out.println(quanLyCovid.toString());
        System.out.println(quanLyCovid.tiemChung_tinh_TP("Long An", 2));
        System.out.println(quanLyCovid.caNhiem_tinh_tp("Long An", "10/10/2021"));
        System.out.println(quanLyCovid.tk_tiemChung_tinh_tp(2));
        System.out.println(quanLyCovid.get_tinh_tp_Max_caNhiem("10/10/2021"));
        System.out.println(quanLyCovid.tk_caNhiem_tinh_tp_DESC());
    }

}
