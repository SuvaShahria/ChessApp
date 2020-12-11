/**
 * This class implements the UserService interface, providing methods to resolve service
 * requests related to the User class/table.
 * 
 * NOTE: currently, it only implements the limited functionality needed to log in and
 * register.
 * 
 * @author Andrew Curry
 */
package com.revature.service.impl;

import java.util.List;

import com.revature.model.User;
import com.revature.repository.RepositoryException;
import com.revature.repository.interfaces.UserRepository;
import com.revature.service.ServiceException;
import com.revature.service.interfaces.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private UserRepository urepo;

    // ---------------------
    // SERVICE METHODS
    // ---------------------

    /**
     * Uses the given urepo instead of the spring-injected bean.
     * Should be used for testing.
     * 
     * @param urepo
     */
    public void useOutsideRepository(UserRepository urepo){
        this.urepo = urepo;
    }

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
     * 
     * @param user : a new user
     * @param barePassword : NOT encrypted yet
     * @return the user after being persisted.
     * @throws ServiceException
     */
    @Override
    public User register(User user, String barePassword) throws ServiceException {
        try{
            return urepo.register(user, barePassword);
        } catch(RepositoryException e){
            throw new ServiceException("RepositoryException: " + e.getMessage());
        }
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

    // TODO delete this
    @SuppressWarnings(value="all")
    private void template() throws ServiceException{
        try{
            throw new RepositoryException(); // REMOVE THIS BEFORE USE
        } catch(RepositoryException e){
            throw new ServiceException("RepositoryException: " + e.getMessage());
        }
    }
    
}
