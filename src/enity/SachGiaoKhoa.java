package enity;

public class SachGiaoKhoa extends Sach {
    protected boolean tinhTrang;

    public SachGiaoKhoa(int maSach, Ngay ngay, double donGia, int SL, String NXB, boolean tinhTrang) {
        super(maSach, ngay, donGia, SL, NXB);
        tinhTrang = tinhTrang;
    }

    public SachGiaoKhoa() {

    }

    public float thanhTien(int SL, float donGia) {
        if (tinhTrang == true) {
            return SL * donGia;
        }
        else return (float) (SL * donGia * (0.5));

    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double tinhThanhTien(){
        return tinhTrang ? SL * donGia : SL * donGia * (0.5);
    }

    @Override
    public String toString() {
        return super.toString() + " Tình Trạng: " + (tinhTrang ? " Mới ": " Cũ ") +
                " Thành Tiền: " + tinhThanhTien() + '\''
                ;
    }
}
