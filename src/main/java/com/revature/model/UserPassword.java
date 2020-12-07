/**
 * Members of this class represent individual entries on the password table.
 * They are kept separate from Users for security reasons. Only the DAO should need to
 * interact with this class.
 * 
 * @author Andrew Curry
 */
package com.revature.model;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Table(
public class UserPassword implements Serializable{
    
    // for serializable
    private static final long serialVersionUID = 0L; // makes compiler happy

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Id
    @OneToOne
    @JoinColumn(name="PASSWORD_USER_ID", nullable=false, referencedColumnName="ID")
    private User user;

    @Column(name="ENCRYPTED_PASS")
    private String encryptedPass;

    // ---------------------
    // CONSTRUCTOR(S)
    // ---------------------

    public UserPassword() {}

    public UserPassword(User user, String encryptedPass){
        this.user = user;
        this.encryptedPass = encryptedPass;
    }
}
