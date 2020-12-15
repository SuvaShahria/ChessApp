/**
 * This interface describes the methods needed to service requests related to MatchRecords
 * 
 * @author Andrew Curry
 */
package com.revature.service.interfaces;

import java.util.List;

import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.service.ServiceException;

public interface MatchService {
    
    // ---------------------
    // SERVICE METHODS
    // ---------------------

    /**
     * Persists the given match record to the database.
     * Works with new AND already-existing entries.
     * 
     * Assumes the fields of the matchRecord are valid.
     * 
     * Throws ServiceException if there are problems communicating with the database.
     * 
     * @param mr
     * @throws ServiceException
     */
    public void save(MatchRecord mr) throws ServiceException;

    /**
     * Returns the match record corresponding to the given id.
     * If no such match record exists, returns null.
     * 
     * Throws ServiceException if there is a problem with the database.
     * 
     * @param id
     * @return
     * @throws ServiceException
     */
    public MatchRecord findMatchRecord(int id) throws ServiceException;
    
    /**
     * Finds all match records.
     * If no match records exist, returns an empty list.
     * 
     * Throws ServiceException if there is a problem with the database.
     * 
     * @return
     * @throws ServiceException
     */
    public List<MatchRecord> findAllMatchRecords() throws ServiceException;

    /**
     * Finds all ongoing match records.
     * If no such match records exist, returns an empty list.
     * 
     * Throws ServiceException if there is a problem with the database.
     * 
     * @return
     * @throws ServiceException
     */
    public List<MatchRecord> findAllOngoingMatchRecords() throws ServiceException;

    /**
     * Finds all finished match records.
     * If no such match records exist, returns an empty list.
     * 
     * Throws ServiceException if there is a problem with the database.
     * 
     * @return
     * @throws ServiceException
     */
    public List<MatchRecord> findAllFinishedMatchRecords() throws ServiceException;
    
    /**
     * Finds all match records where the given user is one of the players.
     * If no such match records exist, returns an empty list.
     * 
     * Throws ServiceException if there is a problem with the database, such as if
     * the user does not exist.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findAllMatchRecordsWithPlayer(User player) 
            throws ServiceException;
    
    /**
     * Finds all ongoing match records where the given user is one of the players.
     * If no such match records exist, returns an empty list.
     * 
     * Throws ServiceException if there is a problem with the database, such as if
     * the user does not exist.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findAllOngoingMatchRecordsWithPlayer(User player) 
            throws ServiceException;
    
    /**
     * Finds all finished match records where the given user is one of the players.
     * If no such match records exist, returns an empty list.
     * 
     * Throws ServiceException if there is a problem with the database, such as if
     * the user does not exist.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findAllFinishedMatchRecordsWithPlayer(User player) 
            throws ServiceException;

    /**
     * Finds all finished match records where the given user is one of the players AND
     * it is their turn.
     * 
     * Throws ServiceException if there is a problem with the database, such as if
     * the user does not exist.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findAllMatchRecordsWithCurrentPlayer(User player) 
            throws ServiceException;
    
    /**
     * Finds all finished match records where the given user is/was the winner.
     * 
     * Throws ServiceException if there is a problem with the database, such as if
     * the user does not exist.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findAllMatchRecordsWithWinner(User player) 
            throws ServiceException;

    /**
     * Finds all finished match records where the given user is/was the loser.
     * 
     * Throws ServiceException if there is a problem with the database, such as if
     * the user does not exist.
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> findAllMatchRecordsWithLoser(User player) 
            throws ServiceException;    
}
