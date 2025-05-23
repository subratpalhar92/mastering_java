package com.palhar.hibernatemaster.dao;

import com.palhar.hibernatemaster.entity.User;
import com.palhar.hibernatemaster.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDao {

    public void saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Could not save user: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null; // Read-only operations might not strictly need a transaction in all cases, but good practice
        List<User> users = null;
        try {
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User", User.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Could not retrieve users: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }


    // public User getUserById(Long id) { ... }
    // public void updateUser(User user) { ... }
    // public void deleteUser(Long id) { ... }
}