import java.io.FileInputStream;
import java.io.IOException;

public class DocFile {
    public void doc(String file){
            try (FileInputStream inf = new FileInputStream(file)) {
                int a = inf.read();
                while(a != -1){
                    System.out.print((char)a);
                    a = inf.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
