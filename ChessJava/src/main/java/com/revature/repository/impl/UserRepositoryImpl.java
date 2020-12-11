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

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void update(User user) throws RepositoryException {
        // TODO Auto-generated method stub

    }

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
    
}
