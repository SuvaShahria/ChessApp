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
import com.revature.rest.interfaces.MatchController;
import com.revature.service.interfaces.MatchService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Controller("matchRecordController")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchControllerImpl implements MatchController {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    //@Autowired
    private MatchService mrService;

    // ---------------------
    // UTILITY / TESTING METHODS
    // ---------------------

    @Override
    public void useOutsideService(MatchService mrService) {
        this.mrService = mrService;
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

    @PostMapping("/recordMove")
    @Override
    public @ResponseBody boolean recordMove(
            @RequestBody int id, 
            @RequestBody String move) {
        return false;
    }
    
}
