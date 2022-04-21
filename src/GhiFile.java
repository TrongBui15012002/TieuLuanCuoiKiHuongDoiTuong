import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class GhiFile {
    public void ghi(String fileName, List<HangHoa> danhSachHH) {
        File file = new File(fileName);
        PrintWriter out;
        try {
            out = new PrintWriter(file);
            for (HangHoa hangHoa : danhSachHH) {
                out.println(hangHoa.toString());
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("- Lỗi.");
            e.printStackTrace();
        }
    }
}
