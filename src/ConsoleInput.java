import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    public Scanner input = new Scanner(System.in);
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa nhapHangHoa() {
        try {
            HangHoa hangHoa = null;
            System.out.print("+ Nhập tên hàng hóa: ");
            String tenHH = input.nextLine();
            System.out.print("+ Nhập số lượng tồn kho: ");
            int sl = input.nextInt();
            input.nextLine();
            System.out.print("+ Nhập đơn giá: ");
            double donGia = input.nextDouble();
            input.nextLine();
            System.out.print("- Loại hàng hóa đang nhập là (1:TP, 2:ĐM, 3:SS): ");
            int loai = input.nextInt();
            input.nextLine();
            if (loai == 1) {
                System.out.println("----Nhập hàng thực phẩm----");
                System.out.print("+ Nhập ngày sản xuất: ");
                String ngaySX = input.nextLine();
                System.out.print("+ Nhập ngày hết hạn: ");
                String ngayHH = input.nextLine();
                System.out.print("+ Nhập nhà cung cấp: ");
                String nhaCungCap = input.nextLine();
                hangHoa = new HangThucPham(tenHH, sl, donGia, ngaySX, ngayHH, nhaCungCap);
            } else if (loai == 2) {
                System.out.println("----Nhập hàng điện máy----");
                System.out.print("+ Nhập thời gian bảo hành: ");
                int tgBaoHanh = input.nextInt();
                input.nextLine();
                System.out.print("+ Nhập công suất: ");
                int congSuat = input.nextInt();
                input.nextLine();
                hangHoa = new HangDienMay(tenHH, sl, donGia, tgBaoHanh, congSuat);
            } else {
                System.out.println("----Nhập hàng sành sứ----");
                System.out.print("+ Nhập nhà sản xuất: ");
                String nhaSX = input.nextLine();
                System.out.print("+ Nhập ngày nhập kho: ");
                String ngayNhapKho = input.nextLine();
                hangHoa = new HangSanhSu(tenHH, sl, donGia, nhaSX, ngayNhapKho);
            }

            return hangHoa;
        } catch (InputMismatchException e) {
            System.out.println("Lỗi định dạng nhập!");
        }
        return null;
    }

}
