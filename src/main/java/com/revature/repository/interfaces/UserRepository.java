/**
 * This interface specifies the methods for DAO functions related to the User class/table.
 * 
 */
package com.revature.repository.interfaces;

import com.revature.model.User;

public interface UserRepository {
    
    // ---------------------
    // METHODS
    // ---------------------

    /**
     * Persists the given user to the database.
     * If the user already exists, the entry will be updated.
     * If the user does not already exist, a new entry will be created.
     * 
     * Assumes the fields of the user are valid.
     * 
     * @param user
     * @return the id of the user after being saved
     */
    public int save(User user) throws RepositoryException;
}
