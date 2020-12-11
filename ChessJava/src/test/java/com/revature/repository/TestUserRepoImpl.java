/**
 * This class contains tests for the UserRepositoryImpl class.
 * 
 * @author Andrew Curry
 */
package com.revature.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.revature.repository.impl.UserRepositoryImpl;
import com.revature.repository.interfaces.UserRepository;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserRepoImpl {

    // ---------------------
    // SETUP / SUPPORT
    // ---------------------
    
    private UserRepository uRepo; // will actually be Impl

    @Before
    public void setup(){
        //ConfigurableApplicationContext appContext 
        //        = new ClassPathXmlApplicationContext("testApplicationContext.xml");
        //uRepo = appContext.getBean("userRepository", UserRepository.class);
        uRepo = new UserRepositoryImpl();
    }

    // ---------------------
    // checkExists() METHODS
    // ---------------------

    @Test
    public void testCheckExists() throws RepositoryException {
        //assertNotNull(sessionFactory);
        assertNotNull(uRepo);
        assertTrue(uRepo.checkExists(1));
    }
    
}
