import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;
import com.revature.model.User.UserType;
import com.revature.rest.impl.UserControllerImpl;
import com.revature.rest.interfaces.UserController;
import com.revature.util.ClientMessageUtil;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains unit tests for the first, incomplete implementation of the
 * UserController interface. When the actual implementation is developed, these tests
 * should be discarded/excluded.
 * 
 * @author Andrew Curry
 */

public class TestDummyUserController {
    
    // ---------------------
    // CLASS-LEVEL VARIABLES
    // ---------------------
    private static UserController ucon;

    // ---------------------
    // SUPPORT METHODS
    // ---------------------

    @Before
    public void setup(){
        ucon = new UserControllerImpl();
    }

    // ---------------------
    // TESTS
    // ---------------------

    @Test
    public void testRegisterUser(){
        User newguy = new User(UserType.PLAYER, "newguy", "new@email.com");
        ClientMessage cm = ucon.registerUser(newguy, "pass");
        assertEquals(
                ClientMessageUtil.REGISTRATION_SUCCESSFUL.getMessage(), 
                cm.getMessage());
    }
}
