package UI;

import SachController.SachController;
import enity.Ngay;
import enity.Sach;
import enity.SachGiaoKhoa;
import enity.SachThamKhao;

import java.util.Scanner;

public class MenuSach {
    private Scanner sc = new Scanner(System.in);
    private SachController quanLySachControllor= new SachController();
    public void MenuSach() {
        int choice;
        do{
            System.out.println("--------MENU--------");
            System.out.println("1. Thêm sách giáo khoa");
            System.out.println("2. Thêm sách tham khảo");
            System.out.println("3. Xoá Sách");
            System.out.println("4. Sửa thông tin sách");
            System.out.println("5. Tìm Sách theo mã sách");
            System.out.println("6. Tính tổng thành tiền");
            System.out.println("7. Tính trung bình đơn giá sách tham khảo");
            System.out.println("8. Xuất sách giáo khoa theo NXB");
            System.out.println("9. In danh sách tất cả sách");
            System.out.println("0. Exit.");
            System.out.println("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    themSachGiaoKhoa();
                    break;

                    case 2:
                        themSachThamKhao();
                        break;

                        case 3:
                            xoaSach();
                            break;

                            case 4:
                                suaSach();
                                break;

                                case 5:
                                    timKiemSach();
                                    break;
                                    case 6:
                                        tinhTongThanhTien();
                                        break;

                                        case 7:
                                            tinhTrungBinhDonGiaSTK();
                                            break;

                                            case 8:
                                                xuatSachNXB();
                                                break;

                                                case 9:
                                                    inDanhSach();
                                                    break;

                                                    case 0:
                                                        System.out.println("Exit.");
                                                        break;
                                                        default:
                                                            System.out.println("Invalid choice.");
                                                            break;


            }
        } while (choice != 0);
        sc.close();
    }

    private Sach nhapThongTin(){
        System.out.println("Nhập mã Sách: ");
        int maSach = sc.nextInt();
        sc.nextLine();
        boolean KiemTraMaSach = quanLySachControllor.KiemTraMaSachTonTai(maSach);
        if(KiemTraMaSach){
            System.out.println("Mã Sách đã tồn tại.");
        }
        else {

            System.out.println("Nhập Ngày Nhập");
            System.out.println("-------------------");
            System.out.println("Nhập ngày: ");
            int ngayInt = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập Tháng: ");
            int thang = sc.nextInt();
            System.out.println("Nhập Năm: ");
            int nam = sc.nextInt();
            System.out.println("Nhập Đơn Giá: ");
            double donGia = sc.nextDouble();
            System.out.println("Nhập số lượng: ");
            int SL = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập Nhà Xuất Bản: ");
            String NXB = sc.nextLine();
            Ngay ngay = new Ngay(ngayInt,thang,nam);

            return new Sach(maSach,ngay,donGia,SL,NXB);
        }
        return null;
    }
    private void themSachGiaoKhoa(){
        Sach thongTinSach = nhapThongTin();
        if(thongTinSach != null){
            System.out.println("Nhập Tình Trạng (1: Mới,  2: Cũ): ");
            int tinhTrang = sc.nextInt();

            SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa(
                    thongTinSach.getMaSach(),
                    thongTinSach.getNgay(),
                    thongTinSach.getDonGia(),
                    thongTinSach.getSL(),
                    thongTinSach.getNXB(),
                    (tinhTrang == 1 ? true: false)
            );

            quanLySachControllor.addSach(sachGiaoKhoa);
            System.out.println("Đã Thêm Thành Công Sách Giáo Khoa.");
        }
        return;
    }

    private void themSachThamKhao(){
        Sach thongtinSach = nhapThongTin();
        if(thongtinSach != null){
            System.out.println("Nhập Thuế: ");
            double thue = sc.nextDouble();

            SachThamKhao sachThamKhao = new SachThamKhao(
                    thongtinSach.getMaSach(),
                    thongtinSach.getNgay(),
                    thongtinSach.getDonGia(),
                    thongtinSach.getSL(),
                    thongtinSach.getNXB(),
                    thue
            );

            quanLySachControllor.addSach(sachThamKhao);
            System.out.println("Đã Thêm Thành Công Sách Tham Khảo.");
        }
        return;
    }

    private void xoaSach(){
        System.out.println("Nhập mã sách cần xoá: ");
        int maSach = sc.nextInt();
        boolean kiemTraMaSach = quanLySachControllor.KiemTraMaSachTonTai(maSach);
        if(kiemTraMaSach){
            quanLySachControllor.removeSach(maSach);
            System.out.println("Đã Xoá Sách Có Mã: " + maSach);
            return;
        }
        else {
            System.out.println("Không Tìm Thấy Mã Sách Có Mã: " + maSach);
        }
    }

    private void suaSach(){
        System.out.println("Nhập mã sách cần sửa: ");
        int maSach = sc.nextInt();
        boolean KiemTraMaSach = quanLySachControllor.KiemTraMaSachTonTai(maSach);
        if(KiemTraMaSach){
            System.out.println("Nhập thông tin mới cho sách: ");
            sc.nextLine();
            System.out.println("Nhập ngày: ");
            int ngayInt = sc.nextInt();
            System.out.println("Nhập tháng: ");
            int thang = sc.nextInt();
            System.out.println("Nhập năm: ");
            int nam = sc.nextInt();
            System.out.println("Nhập Đơn Giá: ");
            double donGia = sc.nextDouble();
            System.out.println("Nhập số lượng: ");
            int SL = sc.nextInt();
            System.out.println("Nhập Nhà Xuất Bản: ");
            String NXB = sc.nextLine();
            Ngay ngay = new Ngay(ngayInt,thang,nam);
            Sach sachMoi;
            System.out.println("SGK (1) --- STK (2): ");
            int loaiSach = sc.nextInt();
            sc.nextLine();
            if(loaiSach == 1){
                System.out.println("Tình trạng sách (1: Mới  ---  2: Cũ): ");
                int tinhTrang = sc.nextInt();
                sachMoi = new SachGiaoKhoa(maSach,ngay,donGia,SL,NXB, (tinhTrang == 1 ? true: false));
            }
            else{
                System.out.println("Nhập thuế: ");
                double thue = sc.nextDouble();
                sachMoi = new SachThamKhao(maSach,ngay,donGia,SL,NXB, thue);
            }
            quanLySachControllor.SuaSach(maSach, sachMoi);
            System.out.println("Đã sửa sách có mã: " + maSach);
        }
        else
            System.out.println("Không tìm thấy mã sách: " + maSach);
    }

    private void timKiemSach(){
        System.out.println("Nhập mã sách cần tìm: ");
        int maSach = sc.nextInt();
        Sach sach = quanLySachControllor.SearchSach(maSach);
        if(sach != null){
            System.out.println("Thông Tin Sách: " + sach);
        }
        else System.out.println("Không tìm thấy sách: " + maSach);
    }

    private void tinhTongThanhTien(){
        System.out.println("Nhập loại sách (1: SGK  ---  2: STK): ");
        String loaiSach = sc.nextLine();
        float tongThanhTien = quanLySachControllor.tinhTongThanhTienTheoLoai(loaiSach);

        System.out.println(" Tổng thành tiền cho: " + (loaiSach == "1" ?" Sách Giáo Khoa " : " Sách Tham Khảo ") + ": " + tongThanhTien );
    }

    private void tinhTrungBinhDonGiaSTK(){
        System.out.println("Trung bình đơn giá sách tham khảo: " + quanLySachControllor.tinhTongThanhTienSachThamKhao());
    }

    private void xuatSachNXB(){
        System.out.println("Nhập tên NXB: ");
        String NXB = sc.nextLine();
        System.out.println("Danh sách của NXB: " + NXB + ":");
        quanLySachControllor.OutputSachGiaoKhoaNXB(NXB).forEach(System.out::println);
    }

    private void inDanhSach(){
        System.out.println("Danh sách tất cả sách: ");
        quanLySachControllor.InDanhSach();
    }
}
