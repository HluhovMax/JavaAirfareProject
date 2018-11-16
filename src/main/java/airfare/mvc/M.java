package airfare.mvc;

import airfare.mvc.dao.UserRepository;
import airfare.mvc.model.staff.User;

/**
 * Created by Max Hluhov on 14.11.2018.
 */
public class M {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        repository.save(new User("Ivan", "Ivanov"));
    }
}
