package dao;

import model.User;
import java.util.List;

public interface UserDao {

    void create(String name, int age, String email);
    void create(User user);

    User read(long id);
    List<User> readAll();

    void update(User user);

    void delete(User user);
}

