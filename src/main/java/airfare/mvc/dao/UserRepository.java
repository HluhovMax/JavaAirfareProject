package airfare.mvc.dao;

import airfare.mvc.model.staff.User;

import java.io.File;
import java.util.List;

/**
 * Created by Max Hluhov on 16.11.2018.
 */
public class UserRepository {
    private JavaIOUtil<User> util;
    private File file =
            new File("src\\main\\resources\\files\\users.txt");

    public void save(User user) {
        util = new JavaIOUtil<>(file, user);
        JavaIOUtil<User> copy = (JavaIOUtil<User>) util.copy();
        List<String> list = copy.reader();
        String userToSave = user.getName() + "," + user.getLastName() + "/";
        list.add(userToSave);
        util.writer(userToSave);
    }
    
}
