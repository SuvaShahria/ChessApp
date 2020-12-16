/**
 * This class handles http requests related to match records.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.interfaces;

import java.util.List;

import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.service.interfaces.MatchService;

public interface MatchController {

    // ---------------------
    // UTILITY / TESTING METHODS
    // ---------------------

    /**
     * Used to replace the automatically-injected spring bean. Used for testing.
     * 
     * @param mrService
     */
    public void useOutsideService(MatchService mrService);

    // ---------------------
    // REQUEST-HANDLING METHODS
    // ---------------------

    /**
     * Retrieves the up-to-date MatchRecord object matching the given id. If not found, 
     * returns null.
     * 
     * @param id
     * @return
     */
    public MatchRecord checkMatchRecord(int id);

    /**
     * Returns the entire moveHistory string from the requested MatchRecord
     * Returns null if failure
     * 
     * @param req
     * @return
     */
    public String getMove(String req);

    /**
     * Replaces the entire moveHistory string on the requested MatchRecord
     * Returns false if failure
     * 
     * @param req
     * @return
     */
    public boolean recordMove(String req);

    /**
     * Starts a new game with the given code, with the given player as white
     * Returns false if failure
     * 
     * @param req
     * @return
     */
    public boolean makeGame(String req);

    /**
     * Adds the given player as black to the pending game indicated by the given code.
     * Returns false if failure
     * 
     * @param req
     * @return
     */
    public boolean findGame(String req);

    /**
     * Returns a list of every match which has the status PENDING (waiting for a player).
     * Returns an empty list if there are no pending games.
     * Returns null if there is a problem.
     * 
     * Intended for GET
     * 
     * @return
     */
    public List<MatchRecord> getAllPendingGames();

    /**
     * Returns a list of every match in which the given user is one of the players.
     * Returns an empty list if there are no such games.
     * Returns null if there is a problem.
     * 
     * Intended for POST
     * 
     * @param user
     * @return
     */
    public List<MatchRecord> getAllGamesWithPlayer(User user);
}
