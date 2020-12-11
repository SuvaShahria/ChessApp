/**
 * This class contains unit tests for the UserServiceImpl class
 * 
 * NOTE: UserServiceImpl is not yet fully implemented
 * 
 * @author Andrew Curry
 */
package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.revature.model.User;
import com.revature.repository.RepositoryException;
import com.revature.service.ServiceException;
import com.revature.repository.interfaces.UserRepository;
import com.revature.service.impl.UserServiceImpl;
import com.revature.service.interfaces.UserService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestUserServiceImpl {
    
    // ---------------------
    // SETUP / SUPPORT
    // ---------------------

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private final String fileName = "testHibernate.cfg.xml";
    private UserService uService; // will actually be Impl
    private UserRepository uRepo;

    @Before
    @SuppressWarnings(value="all") // what could go wrong?
    public void setup(){
        uRepo = mock(UserRepository.class);
        uService = new UserServiceImpl();
        uService.useOutsideRepository(uRepo);
    }

    // ---------------------
    // TESTS
    // ---------------------

    // ---------------------
    // register() TESTS
    // ---------------------

    /**
     * Expects a successful registration
     * 
     * @throws ServiceException
     * @throws RepositoryException
     */
    @Test
    public void testRegister() throws ServiceException, RepositoryException{
        User uIn = new User("user", "email");
        String bp = "password";
        User uOut = new User(1, "user", "email");
        when(uRepo.register(uIn, bp)).thenReturn(uOut);
        User result = uService.register(uIn, bp);
        assertNotNull(result);
        assertEquals(result.getId(), uOut.getId());
        assertEquals(result.getUsername(), uOut.getUsername());
    }

    /**
     * Expects a failed registration
     * 
     * @throws ServiceException
     * @throws RepositoryException
     */
    @Test
    public void testRegisterFail() throws RepositoryException{
        boolean caught = false;
        try{
            User uIn = new User("user", "email");
            String bp = "password";
            when(uRepo.register(uIn, bp)).thenThrow(new RepositoryException());
            uService.register(uIn, bp);
        } catch (ServiceException e){
            caught = true;
        }
        assertTrue(caught);
    }
}
