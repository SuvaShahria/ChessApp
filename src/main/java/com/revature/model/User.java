/**
 * This class represents/models user accounts for the application.
 * NOTE: User objects do not store/remember their own passwords. The DAO class/object
 * performs password checking.
 * 
 * @author Andrew Curry
 */
package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable{

    // for serializable
    private static final long serialVersionUID = 0L; // makes compiler happy

    // ---------------------
    // ENUMS
    // ---------------------

    public enum UserType {
        NONE,
        PLAYER,
        ADMIN, // necessary?
    }

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="USER_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private UserType type;

    @Column(name="USERNAME")
    private String username;

    @Column(name="EMAIL")
    private String email;

    // ---------------------
    // CONSTRUCTOR(S)
    // ---------------------

    public User(){}

    public User(int id, UserType type, String username, String email){
        this.id = id;
        this.type = type;
        this.username = username;
        this.email = email;
    }

    public User(UserType type, String username, String email){
        this.type = type;
        this.username = username;
        this.email = email;
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

    public UserType getType() {
        return this.type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return this.username;
    }

    /**
     * Does not validate the username.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * Does not validate the email.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}