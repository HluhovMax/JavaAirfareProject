package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.dao.prototype.JavaIOUtilFactory;
import airfare.mvc.model.staff.User;

import java.io.File;
import java.util.List;

/**
 * Created by Max Hluhov on 16.11.2018.
 */
public class UserRepository implements Repository<User>{
    private JavaIOUtilFactory<User> factory;
    private File file =
            new File("src\\main\\resources\\files\\users.txt");

    public void save(User user) {
        factory = new JavaIOUtilFactory<>(file, user);
        JavaIOUtil<User> copy = factory.cloneJIOU();
        List < String > list = copy.reader();
        String userToSave = user.getName() + "," + user.getLastName() + "/";
        list.add(userToSave);
        copy.writer(userToSave);
    }
}
