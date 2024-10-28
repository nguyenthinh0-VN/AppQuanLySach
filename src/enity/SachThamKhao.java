package enity;

public class SachThamKhao extends Sach {
    protected double thue;

    public SachThamKhao(int maSach, Ngay ngay, double donGia, int SL, String NXB, double thue) {
        super(maSach, ngay, donGia, SL, NXB);
        this.thue = thue;
    }

    public SachThamKhao() {
    }

    public double thanhTien(int SL, double donGia, float thue) {
        return SL * donGia + thue;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    public double tinhThanhTien(){
        return SL * donGia + thue;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Thuế = " + thue +
                " Thành Tiền = " + tinhThanhTien()
                ;

    }
}
