/**
 * This class handles http requests related to matches.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.impl;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.rest.interfaces.MatchController;
import com.revature.service.ServiceException;
import com.revature.service.interfaces.MatchService;
import com.revature.service.interfaces.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Controller("matchController")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4100"})
public class MatchControllerImpl implements MatchController {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private MatchService mService;

    @Autowired
    private UserService uService;

    // ---------------------
    // UTILITY / TESTING METHODS
    // ---------------------

    @Override
    public void useOutsideService(MatchService mService) {
        this.mService = mService;
    }

    // ---------------------
    // REQUEST-HANDLING METHODS
    // ---------------------

    
    @PostMapping("/hello2")
    public @ResponseBody String helloWorld(){
    	System.out.println("hello worked");
        return "Hello world222!"; 
    }
    
    
    /*
     * need @ResponseStatus(HttpStatus.OK) or wont work
     * let template = {
          user: "user",
          code: code
      } -- look at testmakeGame for out to get elements
      -- user lowercase here
     */
    @PostMapping("/testGetMove")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String testGM(@RequestBody String req){
    	
    	System.out.println("Get Move"+ req);
        return "a4b5 a7a6"; 
    }
    
    
    /*
     * let template = {
             code: code,
             moves: moves
           }
     */
    @PostMapping("/testrecordMove")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody boolean testRM(@RequestBody String req){
    	
    	System.out.println("Recording Move: "+req);
        return true; 
    }
    
    /*
     * let template = {
          whiteUser: "user",
          code: code
      }
      --to get string convert to json, then use get and toString()
     */
    @PostMapping("/testmakeGame")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody boolean testMG( 
            @RequestBody String req){
    	Gson gson=new Gson();
    	JsonObject json = new Gson().fromJson(req, JsonObject.class);
    	//JsonElement j = json.get("whiteUser");
    	String w = json.get("whiteUser").getAsString();
        String code = json.get("code").getAsString();
    	System.out.println(req);
        System.out.println("username is: " + w + ", and code is: " + code);
        System.out.println("is username.equals to user?: " + w.equals("user"));
    	
        return false; 
    }
    
    @PostMapping("/checkMatchRecord")
    @Override
    public @ResponseBody MatchRecord checkMatchRecord(@RequestBody int id) {
        return null;
    }

    /**
     * Returns the entire moveHistory string from the requested MatchRecord
     * Returns null if failure
     * 
     * let template = {user: "user",code: code}
     * 
     * @param req
     * @return
     */
    @PostMapping("/getMove")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody String getMove(@RequestBody String req) {
        try{
            JsonObject json = new Gson().fromJson(req, JsonObject.class);
            String codeString = json.get("code").getAsString();
            int code = Integer.parseInt(codeString);
            MatchRecord mr = mService.findMatchRecordByCode(code);
            if (mr == null) return null;
            return mr.getMoveHistory();
        } catch(ServiceException e){
            return null;
        }
    }

    /**
     * Replaces the entire moveHistory string on the requested MatchRecord
     * Returns false if failure
     * 
     * let template = {code: code, moves: moves}
     * 
     * @param req
     * @return
     */
    @PostMapping("/recordMove")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody boolean recordMove(@RequestBody String req) {
        try{
            JsonObject json = new Gson().fromJson(req, JsonObject.class);
            String codeString = json.get("code").getAsString();
            int code = Integer.parseInt(codeString);
            MatchRecord mr = mService.findMatchRecordByCode(code);
            if (mr == null) return false;
            String moveHistory = json.get("moves").getAsString();
            mr.setMoveHistory(moveHistory);
            mService.save(mr);
            return true; // if no error, success
        } catch(ServiceException e){
            return false;
        }
    }

    /**
     * Starts a new game with the given code, with the given player(username) as white
     * Returns false if failure
     * 
     * let template = {whiteUser: "user",code: code}
     * 
     * @param req
     * @return
     */
    @PostMapping("/makeGame")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody boolean makeGame(@RequestBody String req) {
    	try{
            JsonObject json = new Gson().fromJson(req, JsonObject.class);
            String username = json.get("whiteUser").getAsString();
            User u = uService.findUser(username);
            if (u == null) return false;
            String codeString = json.get("code").getAsString();
            int code = Integer.parseInt(codeString);
            mService.makeGame(u, code);
            return true; // if no error, success
        } catch(ServiceException e){
        	//System.out.println("make game fail");
            return false;
        }
    }

    /**
     * Adds the given player as black to the pending game indicated by the given code.
     * Returns false if failure
     * 
     * let template = {user: username,code: code}
     * 
     * @param req
     * @return
     */
    @PostMapping("/findGame")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody boolean findGame(@RequestBody String req) {
        try{
            JsonObject json = new Gson().fromJson(req, JsonObject.class);
            String username = json.get("user").getAsString();
            System.out.println("DEBUG: about to findUser by username");
            User u = uService.findUser(username);
            if (u == null) return false;
            String codeString = json.get("code").getAsString();
            int code = Integer.parseInt(codeString);
            mService.acceptCode(u, code);
            return true; // if no error, success
        } catch(ServiceException e){
            return false;
        }
    }

    /**
     * Returns a list of every match which has the status PENDING (waiting for a player).
     * Returns an empty list if there are no pending games.
     * Returns null if there is a problem.
     * 
     * @return
     */
    @Override
    @GetMapping("/getAllPendingGames")
    public @ResponseBody List<MatchRecord> getAllPendingGames(){
        try{
            return mService.findAllPendingMatchRecords();
        } catch(ServiceException e){
            return null;
        }
    }

    /**
     * Returns a list of every match in which the given user is one of the players.
     * Returns an empty list if there are no such games.
     * Returns null if there is a problem.
     * 
     * @param user
     * @return
     */
    @Override
    @PostMapping("/getAllGamesWithPlayer")
    public @ResponseBody List<MatchRecord> getAllGamesWithPlayer(@RequestBody User user){
        try{
            return mService.findAllMatchRecordsWithPlayer(user);
        } catch(ServiceException e){
            return null;
        }
    }
}
