package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(String name, int age, String email) { userDao.create(name ,age, email); }
    public void create(User user){userDao.create(user);}

    public User read(long id) { return userDao.read(id); }
    public List<User> readAll(){ return userDao.readAll();}

    public void update(User user) { userDao.update(user); }

    public void delete(User user) { userDao.delete(user); }
}