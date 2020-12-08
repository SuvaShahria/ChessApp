/**
 * This interface specifies the methods for DAO functions related to the MatchRecord 
 * class/table.
 * 
 * @author Andrew Curry
 */
package com.revature.repository.interfaces;

import java.util.List;

import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.repository.RepositoryException;


public interface MatchRecordRepository {

    // ---------------------
    // ENUM(S)
    // ---------------------

    /**
     * This enum is used as a parameter in different overloads of findMatchRecordsBy.
     */
    public enum MatchStatusFilter{
        ALL,
        ONGOING,
        FINISHED,
        WON_BY_GIVEN_USER,
        LOST_BY_GIVEN_USER,
        CURRENT_USER_IS_GIVEN_USER,
    }

    // ---------------------
    // METHODS
    // ---------------------

    /**
     * Persists the given match record to the database.
     * Works with new AND already-existing entries.
     * 
     * Assumes the fields of the matchRecord are valid.
     * 
     * Throws RepositoryException if there are problems communicating with the database.
     * 
     * @param mr
     * @throws RepositoryException
     */
    public void save(MatchRecord mr) throws RepositoryException;

    /**
     * Returns the match record corresponding to the given id.
     * If no such match record exists, returns null.
     * 
     * @param id
     * @return
     * @throws RepositoryException
     */
    public MatchRecord findMatchRecord(int id) throws RepositoryException;

    /**
     * Finds all match records where the given user is one of the players.
     * If no such match records exist, returns an empty list.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findMatchRecordsBy(User user) throws RepositoryException;

    /**
     * Finds all match records matching the given status filter.
     * Only supports ALL, ONGOING, and FINISHED.
     * 
     * @param filter
     * @return
     */
    public List<MatchRecord> findMatchRecordsBy(MatchStatusFilter filter) 
            throws RepositoryException;

    /**
     * Finds all match records where the given user is one of the players, AND the status
     * matches the given status filter.
     * Supports all filter types.
     * 
     * @param user
     * @param filter
     * @return
     * @throws RepositoryException
     */
    public List<MatchRecord> findMatchRecordsBy(User user, MatchStatusFilter filter) 
            throws RepositoryException;
    
}
