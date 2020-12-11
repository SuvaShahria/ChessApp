/**
 * This class contains tests for the UserRepositoryImpl class.
 * 
 * It currently has a clusmy way of getting around my problems with Spring.
 * 
 * @author Andrew Curry
 */
package com.revature.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.revature.model.User;
import com.revature.repository.impl.UserRepositoryImpl;
import com.revature.repository.interfaces.UserRepository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
        // now put one in there and see if we can find it
        User realUser = new User("user", "real@email.com");
        Session session = sfactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(realUser);
        tx.commit();
        assertTrue(urepo.checkExists(realUser));
        assertTrue(urepo.checkExists(realUser.getId()));
        assertTrue(urepo.checkExists(realUser.getUsername()));
    }

    // ---------------------
    // register() METHODS
    // ---------------------
    
    @Test
    @SuppressWarnings(value="unchecked")
    public void testRegister() throws RepositoryException {
        // register a new user
        User  addMe = new User("addMe", "add@email.com");
        String addPassword = "password";
        User added = urepo.register(addMe, addPassword);
        assertNotNull(added);
        assertEquals(addMe.getUsername(), added.getUsername());
        assertEquals(addMe.getEmail(), added.getEmail());
        // lets manually verify that it exists
        Session session = sfactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("username", "addMe"));
        List<User> userList = crit.list();
        tx.commit();
        assertEquals(1, userList.size());
        // now what happens when we try to register a user that already exists?
        boolean wasCaught = false;
        try{
            urepo.register(addMe, "password");
        }
        catch(RepositoryException e){
            wasCaught = true;
        }
        assertTrue(wasCaught);
    }
}
