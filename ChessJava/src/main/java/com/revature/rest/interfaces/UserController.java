/**
 * This interface describes the methods needed for the UserController, which bridges the
 * gap between the dispatcher servlet and UserService.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.interfaces;

//import javax.servlet.http.HttpServletRequest;
import com.revature.ajax.ClientMessage;
import com.revature.model.User;

public interface UserController {

    // ---------------------
    // REQUEST-HANDLING METHODS
    // ---------------------

    /**
     * Handles registering a new user to the system. Must be a new user, not already in
     * the database.
     * 
     * Intended for POST
     * 
     * @param user
     * @param barePassword
     * @return
     */
    public User registerUser(User user, String barePassword);

    /**
     * Handles a user logging in to the system.
     * 
     * Intended for POST
     * 
     * @param username
     * @param barePassword
     * @return
     */
    public User logIn(String username, String barePassword);
}
