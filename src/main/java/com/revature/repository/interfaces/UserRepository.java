/**
 * This interface specifies the methods for DAO functions related to the User class/table.
 * 
 * @author Andrew Curry
 */
package com.revature.repository.interfaces;

import java.util.List;

import com.revature.model.User;
import com.revature.model.User.UserType;
import com.revature.repository.RepositoryException;

public interface UserRepository {

    // ---------------------
    // METHODS
    // ---------------------

    /**
     * Persists the given user to the database.
     * Use this method to update a user that already exists.
     * 
     * Assumes the fields of the user are valid.
     * 
     * Throws RepositoryException if the user is not already in the DB - use register()
     * 
     * @param user : a user that already exists
     * @throws RepositoryException : if there is a problem with the database
     */
    public void save(User user) throws RepositoryException;

    /**
     * Persists the given user to the database.
     * Use this method to write a brand new user to the database.
     * 
     * Will encrypt, but not validate, the given password.
     * 
     * Throws RepositoryException if the user is already in the DB - use register()
     * 
     * @param user : a new user
     * @param barePassword : NOT encrypted yet
     * @return the id of the user after being persisted.
     * @throws RepositoryException
     */
    public int register(User user, String barePassword) throws RepositoryException;

    /**
     * Returns the user corresponding to the given id.
     * If no such user exists, returns null.
     * 
     * @param id
     * @return
     * @throws RepositoryException : if there is a problem with the database
     */
    public User findUser(int id) throws RepositoryException;

    /**
     * Returns the user corresponding to the given username.
     * If no such user exists, returns null.
     * 
     * @param username
     * @return
     * @throws RepositoryException : if there is a problem with the database
     */
    public User findUser(String username) throws RepositoryException;

    /**
     * Returns a list containing all of the registered users matching the given type.
     * If no such users exists, returns an empty list.
     * 
     * @param type
     * @return
     * @throws RepositoryException : if there is a problem with the database
     */
    public List<User> findByType(UserType type) throws RepositoryException;

    /**
     * Determines if the given password corresponds to the given user.
     * 
     * Throws RepositoryException if there is a problem with the database, including if
     * the given user does not exist.
     * 
     * @param user
     * @param attemptedPassword : bare text, unencrypted
     * @return true if the given password unlocks the given user account, false otherwise.
     * @throws RepositoryException
     */
    public boolean checkPassword(User user, String attemptedPassword) 
            throws RepositoryException;
}
