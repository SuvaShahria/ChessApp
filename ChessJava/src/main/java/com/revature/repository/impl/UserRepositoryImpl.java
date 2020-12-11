/**
 * This class implements the required methods relating to persisting and reading User
 * data from the database.
 * 
 * @author Andrew Curry
 */
package com.revature.repository.impl;

import java.util.List;

import com.revature.model.User;
import com.revature.repository.RepositoryException;
import com.revature.repository.interfaces.UserRepository;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private SessionFactory sessionFactory;

    // ---------------------
    // INTERFACE METHODS
    // ---------------------

    @Override
    public void update(User user) throws RepositoryException {
        // TODO Auto-generated method stub

    }

    /**
     * Persists the given user to the database.
     * Use this method to write a brand new user to the database.
     * 
     * Throws RepositoryException if the user is already in the DB - use update() for
     * existing users
     * 
     * @param user : a new user
     * @param securePassword : encrypted
     * @return the id of the user after being persisted.
     * @throws RepositoryException
     */
    @Override
    public int register(User user, String securePassword) throws RepositoryException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public User findUser(int id) throws RepositoryException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUser(String username) throws RepositoryException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAllUsers() throws RepositoryException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean checkPassword(User user, String attemptedPassword) 
            throws RepositoryException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Returns true if either the id or username of the given user is found in the db, and
     * false otherwise.
     * 
     * Throws RepositoryException if there is a problem with the database
     * 
     * @param user
     * @return
     * @throws RepositoryException
     */
    @Override
    public boolean checkExists(User user) throws RepositoryException {
        return checkExists(user.getId()) || checkExists(user.getUsername());
    }

    /**
     * Returns true if the id is found in the db, and false otherwise.
     * 
     * Throws RepositoryException if there is a problem with the database
     * 
     * @param id
     * @return
     * @throws RepositoryException
     */
    @Override
    public boolean checkExists(int id) throws RepositoryException {
        try{
            Session session = sessionFactory.getCurrentSession();
            User u = (User)session.get(User.class, id);
            session.close();
            return u != null;
        } catch(HibernateException e){
            throw new RepositoryException("HibernateException: " + e.getMessage());
        }
    }

    /**
     * Returns true if the username is found in the db, and false otherwise.
     * 
     * Throws RepositoryException if there is a problem with the database
     * 
     * @param id
     * @return
     * @throws RepositoryException
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean checkExists(String username) throws RepositoryException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria crit = session.createCriteria(User.class);
            crit.add(Restrictions.eq("username", username));
            List<User> userList = crit.list();
            session.close();
            return !userList.isEmpty();
        } catch(HibernateException e){
            throw new RepositoryException("HibernateException: " + e.getMessage());
        }
    }

    // TODO delete this
    @SuppressWarnings(value="all")
    private void template() throws RepositoryException{
        try{
            Session session = sessionFactory.getCurrentSession();
            session.close();
        } catch(HibernateException e){
            throw new RepositoryException("HibernateException: " + e.getMessage());
        }
    }
    
}
