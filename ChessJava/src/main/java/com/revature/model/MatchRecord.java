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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Column(name="MATCH_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private MatchStatus status;

    @Column(name="MOVE_HISTORY")
    private String moveHistory;

    // ---------------------
    // CONSTRUCTOR(S)
    // ---------------------

    /**
     * Does NOT intialize any fields.
     */
    public MatchRecord(){}

    /**
     * Does NOT validate any fields.
     */
    public MatchRecord(
            int id, 
            User whiteUser, 
            User blackUser, 
            User currentTurnUser, 
            MatchStatus status,
            String moveHistory) {
        this.id = id;
        this.whiteUser = whiteUser;
        this.blackUser = blackUser;
        this.currentTurnUser = currentTurnUser;
        this.status = status;
        this.moveHistory = moveHistory;
    }

    /**
     * Does NOT validate any fields.
     */
    public MatchRecord(
            User whiteUser, 
            User blackUser, 
            User currentTurnUser, 
            MatchStatus status,
            String moveHistory) {
        this.whiteUser = whiteUser;
        this.blackUser = blackUser;
        this.currentTurnUser = currentTurnUser;
        this.status = status;
        this.moveHistory = moveHistory;
    }

    // ---------------------
    // SETTERS AND GETTERS
    // ---------------------

    public int getId() {
        return this.id;
    }

    /**
     * Does not validate the ID.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public User getWhiteUser() {
        return this.whiteUser;
    }

    /**
     * Does not validate the user.
     * @param whiteUser
     */
    public void setWhiteUser(User whiteUser) {
        this.whiteUser = whiteUser;
    }

    public User getBlackUser() {
        return this.blackUser;
    }

    /**
     * Does not validate the user.
     * @param blackUser
     */
    public void setBlackUser(User blackUser) {
        this.blackUser = blackUser;
    }

    public User getCurrentTurnUser() {
        return this.currentTurnUser;
    }

    /**
     * Does not validate the user.
     * @param currentTurnUser
     */
    public void setCurrentTurnUser(User currentTurnUser) {
        this.currentTurnUser = currentTurnUser;
    }

    public MatchStatus getStatus() {
        return this.status;
    }

    /**
     * Does not validate the status.
     * @param status
     */
    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    /**
     * Returns a string containing the move history of this match, in standard (algebraic)
     * chess notaton. Each move is seperated by a comma. A game with no moves yet will
     * produce the empty string.
     * 
     * EG, "e4 e5,a2 a1,e5 e8"
     * 
     * @return
     */
    public String getMoveHistory() {
        return this.moveHistory;
    }

    /**
     * Does not validate the history.
     * @param moveHistory
     */
    public void setMoveHistory(String moveHistory) {
        this.moveHistory = moveHistory;
    }

    // ---------------------
    // OTHER PUBLIC METHODS
    // ---------------------

    /**
     * Records a single move, adding it to the move history. Also, switches the
     * currentTurnUser to the other, eg from white to black.
     * 
     * The move string should be a single turn/move, without commas, eg "e4 e5"
     * Does NOT validate the new move string.
     * 
     * @param move
     */
    public void recordMove(String move){
        recordMove(move, true);
    }

    /**
     * Records a single move, adding it to the move history. Also, if the parameter
     * changeCurrentTurnUser is true, switches the current player.
     * 
     * The move string should be a single turn/move, without commas, eg "e4 e5"
     * Does NOT validate the new move string.
     * 
     * @param move
     * @param changeCurrentTurnUser
     */
    public void recordMove(String move, boolean changeCurrentTurnUser){
        moveHistory = moveHistory + "," + move;
        if (changeCurrentTurnUser){
            if (currentTurnUser.getId() == whiteUser.getId())
                setCurrentTurnUser(blackUser);
            else setCurrentTurnUser(whiteUser);
        }
    }
}
