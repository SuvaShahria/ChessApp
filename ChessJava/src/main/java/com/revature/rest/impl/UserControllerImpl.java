/**
 * This class handles http requests related to users.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.impl;

import com.revature.model.User;
import com.revature.model.UserWithPassword;
import com.revature.rest.interfaces.UserController;
import com.revature.service.ServiceException;
import com.revature.service.interfaces.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerImpl implements UserController{

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private UserService uService;

    // ---------------------
    // UTILITY / TESTING METHODS
    // ---------------------

    /**
     * Used to replace the automatically-injected spring bean. Used for testing.
     * 
     * @param uService
     */
    public void useOutsideService(UserService uService){
        this.uService = uService;
    }
    
    // ---------------------
    // REQUEST-HANDLING METHODS
    // ---------------------

    /**
     * very simple get request handler for testing
     * 
     * @return
     */
    @GetMapping("/hello")
    public @ResponseBody String helloWorld(){
        return "Hello world!"; 
    }

    /**
     * Handles registering a new user to the system. Must be a new user, not already in
     * the database.
     * 
     * Intended for POST
     * 
     * @param user
     * @param barePassword
     * @return the user after being registered, or null if registration was not successful.
     */
    @PostMapping("/registerUser")
    @Override
    public @ResponseBody User registerUser(@RequestBody UserWithPassword uwp){
        try{
            //System.out.println("-----" + uwp.getUsername() + "-----");
            User u = uService.register(uwp.makeUser(), uwp.getBarePassword());
            System.out.println("DEBUG: is user null? " + (u == null));
            return u;
        } catch (ServiceException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Handles a user logging in to the system. Returns the user object if successful,
     * false otherwise.
     * 
     * Intended for POST
     * 
     * @param username
     * @param barePassword
     * @return
     */
    @PostMapping("/logIn")
    @Override
    public @ResponseBody User logIn(
            @RequestBody String username, 
            @RequestBody String barePassword){
        try{
            User user = new User(username); // clumsy/lazy
            return uService.logIn(user, barePassword);
        } catch (ServiceException e){
            return null;
        }
    }

    @PostMapping("/testRegisterUser")
    public @ResponseBody UserWithPassword postRegisterTest(@RequestBody UserWithPassword uwp){
        return uwp;
    }
}
