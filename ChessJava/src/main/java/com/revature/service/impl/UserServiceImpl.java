/**
 * This class implements the UserService interface, providing methods to resolve service
 * requests related to the User class/table.
 * 
 * NOTE: currently, it only implements the limited functionality needed to log in and
 * register.
 * 
 */
package com.revature.service.impl;

import java.util.List;

import com.revature.model.User;
import com.revature.service.ServiceException;
import com.revature.service.interfaces.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void update(User user) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /**
     * Persists the given user to the database.
     * Use this method to write a brand new user to the database.
     * 
     * Will encrypt, but not validate, the given password.
     * 
     * Throws ServiceException if the user is already in the DB - use update() for
     * existing users
     * 
     * @param user : a new user
     * @param barePassword : NOT encrypted yet
     * @return the user after being persisted.
     * @throws ServiceException
     */
    @Override
    public User register(User user, String barePassword) throws ServiceException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public User findUser(int id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUser(String username) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean checkPassword(User user, String attemptedPassword) throws ServiceException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
