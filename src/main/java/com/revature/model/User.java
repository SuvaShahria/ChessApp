/**
 *  This class represents/models user accounts for the application.
 * 
 */
package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User{

    // ---------------------
    // ENUMS
    // ---------------------

    public enum UserType {
        NONE,
        PLAYER,
        ADMIN,
    }

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}