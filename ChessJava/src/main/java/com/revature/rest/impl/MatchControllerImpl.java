/**
 * This class handles http requests related to matches.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.rest.interfaces.MatchController;
import com.revature.service.ServiceException;
import com.revature.service.interfaces.MatchService;
import com.revature.service.interfaces.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Controller("matchRecordController")
@CrossOrigin(origins = "http://localhost:4200")
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
    	String w = json.get("whiteUser").toString();
    	String code = json.get("code").toString();
    	System.out.println(req);
    	System.out.println(w);
    	
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
    @PostMapping("/makeGame")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody String getMove(@RequestBody String req) {
        try{
            JsonObject json = new Gson().fromJson(req, JsonObject.class);
            String codeString = json.get("user").toString();
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
            String codeString = json.get("user").toString();
            int code = Integer.parseInt(codeString);
            MatchRecord mr = mService.findMatchRecordByCode(code);
            if (mr == null) return false;
            String moveHistory = json.get("moves").toString();
            mr.setMoveHistory(moveHistory);
            return true;
        } catch(ServiceException e){
            return false;
        }
    }

    /**
     * Starts a new game with the given code, with the given player(username) as white
     * Returns false if failure
     * 
     * @param req
     * @return
     */
    @Override
    public boolean makeGame(String req) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean findGame(String req) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
