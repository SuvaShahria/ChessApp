/**
 * This class handles http requests related to matches.
 * 
 * NOTE: it is not complete. There are many methods not yet specified.
 * 
 * @author Andrew Curry
 */
package com.revature.rest.impl;

import com.revature.model.MatchRecord;
import com.revature.rest.interfaces.MatchRecordController;
import com.revature.service.interfaces.MatchRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("matchRecordController")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchRecordControllerImpl implements MatchRecordController {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private MatchRecordService mrService;

    // ---------------------
    // UTILITY / TESTING METHODS
    // ---------------------

    @Override
    public void useOutsideService(MatchRecordService mrService) {
        this.mrService = mrService;
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
