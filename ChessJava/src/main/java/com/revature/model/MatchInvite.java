/**
 * Members of this class represent an invite from one player to another to play a match.
 * 
 * @author Andrew Curry
 */
package com.revature.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="MATCH_INVITE")
public class MatchInvite implements Serializable{

    // for serializable
    private static final long serialVersionUID = 0L; // makes compiler happy
    
    // ---------------------
    // ENUM(S)
    // ---------------------

    public enum InviteStatus{
        NONE,
        PENDING,
        ACCEPTED,
        REJECTED,
    }
}
