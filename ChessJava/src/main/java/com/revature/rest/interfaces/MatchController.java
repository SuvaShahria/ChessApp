/**
 * This class handles http requests related to match records.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.interfaces;

import com.revature.model.MatchRecord;
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
     * Records the given move to the MatchRecord entry indicated by the given id.
     * The string should be a single move, in chess notation.
     * 
     * @param id
     * @param move
     * @return true if the move is successfully recorded, false otherwise
     */
    public boolean recordMove(int id, String move);
    
}
