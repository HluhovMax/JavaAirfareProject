package airfare.mvc.dao.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class JavaIOUtil {
    BufferedReader reader;
    String filePath;

    public JavaIOUtil(String filePath) {
        this.filePath = filePath;
        try {
            reader = new BufferedReader(new FileReader(new File(this.filePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader reader() {
        return reader;
    }

    public Object copy() {
        JavaIOUtil copy = new JavaIOUtil(filePath);
        return copy;
    }
}
