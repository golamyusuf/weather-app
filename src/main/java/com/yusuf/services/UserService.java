package com.yusuf.services;

import com.yusuf.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "userPU")
    private EntityManager em;

    public void createUser(User user) {
        em.persist(user);
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void updateUser(User user) {
        em.merge(user);
    }

    public void deleteUser(Long id) {
        User user = findUserById(id);
        if (user != null) {
            em.remove(user);
        }
    }
}
