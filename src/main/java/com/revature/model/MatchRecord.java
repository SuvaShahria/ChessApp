/**
 * Members of this class represents the saved state of a single chess match. It has no
 * understanding of the rules of the game, and will not help you actually play a game of
 * chess - it is used to save matches in and retrieve them from the database.
 * 
 * @author Andrew Curry
 */
package com.revature.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MATCH_RECORD")
public class MatchRecord implements Serializable{
    
    // for serializable
    private static final long serialVersionUID = 0L; // makes compiler happy

    // ---------------------
    // ENUMS
    // ---------------------

    public enum UserType {
        NONE, // should never be used - indicates problem
        PLAYER,
        ADMIN, // necessary?
        ALL, // should never be used by an actual User
    }
}
