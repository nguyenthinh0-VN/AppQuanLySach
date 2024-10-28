package SachController;

import enity.Sach;
import enity.SachGiaoKhoa;
import enity.SachThamKhao;

import java.util.ArrayList;
import java.util.List;

public class SachController {
    private ArrayList<Sach> danhSachSach;

    public SachController() {
        danhSachSach = new ArrayList<>();
    }
    public boolean KiemTraMaSachTonTai(int maSach){
        for(Sach sach : danhSachSach){
            if(sach.getMaSach() == maSach){
                return true;
            }
        }
        return false;
    }

    //Ham Them Sach
    public void addSach(Sach sach){
        danhSachSach.add(sach);
    }

    //Ham Xoa Sach
    public void removeSach(int maSach){
        //KT maSach moi nhap co giong maSach trong danhsachSach
        //neu co thi xoa

        if(danhSachSach.get(maSach).getMaSach() == maSach){
            danhSachSach.remove(maSach);
        }
    }

    //Ham sua sach
    public void SuaSach(int maSach, Sach sachDaSua){
        for(int i = 0; i < danhSachSach.size(); i++){
            if(danhSachSach.get(i).getMaSach() == maSach){
                danhSachSach.set(i, sachDaSua);
            }
            break;
        }
    }

    public Sach SearchSach(int maSach){
        for(Sach sach : danhSachSach){
            if(sach.getMaSach() == maSach){
                return sach;
            }
        }
        return null;
    }

    public float tinhTongThanhTienTheoLoai(String loaiSach){
        float tongThanhTien = 0;
        for(Sach sach : danhSachSach){
            if(loaiSach.equals("1") && sach instanceof SachGiaoKhoa){
                tongThanhTien += ((SachGiaoKhoa) sach). tinhThanhTien();
            }
        }
        return tongThanhTien;
    }

    public double tinhTongThanhTienSachThamKhao(){
        double tongThanhTien = 0;
        int demSachThamKhao = 0;
        for(Sach sach : danhSachSach){
            if(sach instanceof SachGiaoKhoa){
                SachThamKhao sachThamKhao = (SachThamKhao) sach;
                tongThanhTien += sachThamKhao.tinhThanhTien();
                demSachThamKhao++;
            }
        }return demSachThamKhao > 0 ? tongThanhTien/demSachThamKhao : 0;
    }

    public ArrayList<SachGiaoKhoa> OutputSachGiaoKhoaNXB(String NXB) {
        ArrayList<SachGiaoKhoa> sachGiaoKhoaNXB = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if(sach instanceof SachGiaoKhoa){
                SachGiaoKhoa sachgiaoKhoa = (SachGiaoKhoa) sach;
                if(sachgiaoKhoa.getNXB().equalsIgnoreCase(NXB)){
                    sachGiaoKhoaNXB.add(sachgiaoKhoa);
                }
            }
        }return sachGiaoKhoaNXB;
    }

    public void InDanhSach() {
        for (Sach sach : danhSachSach) {
            System.out.println(sach);
        }
    }
}
