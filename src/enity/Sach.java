package enity;

public class Sach {

    protected int maSach;
    protected Ngay ngay = new Ngay();
    protected double donGia;
    protected int SL;
    protected String NXB;

    public Sach(int maSach, Ngay ngay, double donGia, int SL, String NXB) {
        this.maSach = maSach;
        this.ngay = ngay;
        this.donGia = donGia;
        this.SL = SL;
        this.NXB = NXB;
    }

    public Sach() {
    }


    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public Ngay getNgay() {
        return ngay;
    }

    public void setNgay(Ngay ngay) {
        this.ngay = ngay;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    @Override
    public String toString() {
        return " Mã Sách: " + maSach +
                " Ngày Nhập: " + ngay +
                " Đơn Giá: " + donGia +
                " Số Lượng: " + SL +
                " NXB: " + NXB
                ;
    }
}
