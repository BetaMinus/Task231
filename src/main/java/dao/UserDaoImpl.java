package dao;

import model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(String name, int age, String email) { entityManager.persist(new User(name, age, email)); }
    public void create(User user) { entityManager.persist(user);}

    public User read(long id) { return entityManager.find(User.class, id); }
    public List<User> readAll() { return entityManager.createQuery("FROM User").getResultList(); }

    public void update(User user){ entityManager.merge(user); }

    public void delete(User user) { entityManager.remove(entityManager.merge(user)); }

}

