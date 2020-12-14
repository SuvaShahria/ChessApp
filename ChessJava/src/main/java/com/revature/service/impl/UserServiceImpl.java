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
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private UserRepository uRepo;

    // ---------------------
    // SERVICE METHODS
    // ---------------------

    /**
     * Uses the given uRepo instead of the spring-injected bean.
     * Should be used for testing.
     * 
     * @param uRepo
     */
    public void useOutsideRepository(UserRepository uRepo){
        this.uRepo = uRepo;
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
     * Returns null if the user is already in the DB - use update() for
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
            return (uRepo.checkExists(user)) ? uRepo.register(user, barePassword) : null;
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

    /**
     * Determines if the given password corresponds to the given user. Returns the user
     * if login is successful, null otherwise.
     * 
     * Throws ServiceException if there is a problem with the database.
     * 
     * @param user
     * @param attemptedPassword : bare text, unencrypted
     * @return true if the given password unlocks the given user account, false otherwise.
     * @throws ServiceException
     */
    @Override
    public User logIn(User user, String attemptedPassword) throws ServiceException {
        try{
            User found = uRepo.findUser(user);
            if (found == null) return null; // can't log in to a user that doesnt exist
            else return (uRepo.checkPassword(found, attemptedPassword)) ? found : null;
        } catch(RepositoryException e){
            throw new ServiceException("RepositoryException: " + e.getMessage());
        }
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
