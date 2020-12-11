/**
 * This class contains tests for the UserRepositoryImpl class.
 * 
 * It currently has a clusmy way of getting around my problems with Spring.
 * 
 * @author Andrew Curry
 */
package com.revature.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.revature.model.User;
import com.revature.repository.impl.UserRepositoryImpl;
import com.revature.repository.interfaces.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.junit.Before;
import org.junit.Test;

public class TestUserRepoImpl {

    // ---------------------
    // SETUP / SUPPORT
    // ---------------------
    
    private final String fileName = "testHibernate.cfg.xml";
    private UserRepository urepo; // will actually be Impl
    private SessionFactory sfactory; // used to manuaully change/check data, NOT by repo

    @Before
    @SuppressWarnings(value="all") // what could go wrong?
    public void setup(){
        urepo = new UserRepositoryImpl();
        urepo.useOutsideSessionFactory(
                new Configuration().configure(fileName).buildSessionFactory());
        sfactory = new Configuration().configure(fileName).buildSessionFactory();
    }

    // ---------------------
    // checkExists() METHODS
    // ---------------------

    @Test
    public void testCheckExists() throws RepositoryException {
        // look for user(s) that aren't there
        assertFalse(urepo.checkExists(12345));
        assertFalse(urepo.checkExists("notAUser"));
        User notAUser = new User(12345, "notAUser", "not@email.com");
        assertFalse(urepo.checkExists(notAUser));
    }


    
}
