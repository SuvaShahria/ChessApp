/**
 * This class handles http requests related to users.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.impl;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;
import com.revature.rest.interfaces.UserController;
import com.revature.util.ClientMessageUtil;

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
     * NOTE: This is only a dummy implementation for development purposes
     * TODO actual impl
     * 
     * @param user
     * @param barePassword
     * @return
     */
    @PostMapping("/registerUser")
    public @ResponseBody ClientMessage registerUser(
            @RequestBody User user, 
            @RequestBody String barePassword){
        String username = user.getUsername();
        // trying to register a user that already exists?
        if (username.equals("user") || username.equals("admin")){
            return ClientMessageUtil.SOMETHING_WRONG;
        }
        else return ClientMessageUtil.REGISTRATION_SUCCESSFUL;
    }

    /**
     * Handles a user logging in to the system.
     * 
     * Intended for POST
     * 
     * NOTE: This is only a dummy implementation for development purposes
     * TODO actual impl
     * 
     * @param username
     * @param barePassword
     * @return
     */
    @PostMapping("/logIn")
    public @ResponseBody ClientMessage logIn(
            @RequestBody String username, 
            @RequestBody String barePassword){
        boolean isUser = username.equals("user") && barePassword.equals("password");
        boolean isAdmin = username.equals("admin") && barePassword.equals("admin");
        if (isUser || isAdmin) return ClientMessageUtil.LOG_IN_SUCCESSFUL;
        else return ClientMessageUtil.SOMETHING_WRONG;
    }
}
