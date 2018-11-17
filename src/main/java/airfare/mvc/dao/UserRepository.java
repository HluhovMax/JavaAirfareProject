package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.model.staff.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private JavaIOUtil original;
    private String filePath = "src\\main\\resources\\files\\user.csv";

    public UserRepository() {
        original = new JavaIOUtil(filePath);
    }

    public void save(User user) {
        JavaIOUtil copy = (JavaIOUtil) original.copy();
        String fileTostring;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader =
                     copy.reader()) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if (fileTostring.length() != 0) {
                    items.add(fileTostring);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userToSave = user.getName() + ","
                + user.getLastName() + "/";
        items.add(userToSave);
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            writer.write(userToSave + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
