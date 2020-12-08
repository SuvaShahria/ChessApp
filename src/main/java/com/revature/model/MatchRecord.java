/**
 * Members of this class represents the saved state of a single chess match. It has no
 * understanding of the rules of the game, and will not help you actually play a game of
 * chess - it is used to save matches in and retrieve them from the database.
 * 
 * @author Andrew Curry
 */
package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MATCH_RECORD")
public class MatchRecord implements Serializable{
    
    // for serializable
    private static final long serialVersionUID = 0L; // makes compiler happy

    // ---------------------
    // ENUMS
    // ---------------------

    /**
     * This enum describes the state of the game - EG, ongoing or finished
     */
    public enum MatchStatus {
        NONE, // should never be used - indicates problem
        ONGOING, // game is not over yet
        WHITE_VICTORY,
        BLACK_VICTORY,
    }

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="WHITE_USER_ID", nullable = false, referencedColumnName = "ID")
    private User whiteUser;

    @ManyToOne
    @JoinColumn(name="BLACK_USER_ID", nullable = false, referencedColumnName = "ID")
    private User blackUser;

    @ManyToOne
    @JoinColumn(name="CURRENT_TURN_USER_ID", nullable = false, referencedColumnName = "ID")
    private User currentTurnUser;

    @Column(name="MOVE_HISTORY")
    private String moveHistory;

    // ---------------------
    // CONSTRUCTOR(S)
    // ---------------------
}
