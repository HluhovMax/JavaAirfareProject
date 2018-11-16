package airfare.mvc.dao.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class JavaIOUtil<T> implements Copyable{
    private File file;
    private T t;

    public JavaIOUtil(File file, T t) {
        this.file = file;
        this.t = t;
    }

    public List<String> reader() {
        String fileToString;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {
            while ((fileToString = reader.readLine()) != null) {
                fileToString = fileToString.trim();
                if ((fileToString.length()) != 0) {
                    items.add(fileToString);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void writer(String itemToSave) {
        try (FileWriter writer =
                     new FileWriter(file, true)) {
            writer.write(itemToSave + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object copy() {
        JavaIOUtil<T> copy = new JavaIOUtil<>(file, t);
        return copy;
    }
}
