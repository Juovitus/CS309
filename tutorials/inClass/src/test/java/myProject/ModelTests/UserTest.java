package myProject.ModelTests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import myProject.Models.User;
import org.junit.Test;
/**
 * 
 * @author Noah Hoss
 *
 */
public class UserTest {
    private static final Integer USER_ID_TEST = 1;
    private static final String USER_NAME_TEST = "Juovitus";
    private static final String USER_PASSWORD_TEST = "password";
    private static final String USER_EMAIL_TEST = "juovitus@gmail.com";
    /**
     * Mock then test getId
     */
    @Test
    public void testUserId(){
        User mockedReturner = mock(User.class);
        when(mockedReturner.getId()).thenReturn(USER_ID_TEST);
        assertEquals(mockedReturner.getId(), USER_ID_TEST);
    }
    /**
     * Mock then test getUsername
     */
    @Test
    public void testUserName(){
        User mockedReturner2 = mock(User.class);
        when(mockedReturner2.getUserName()).thenReturn(USER_NAME_TEST);
        assertEquals(mockedReturner2.getUserName(), USER_NAME_TEST);
    }
    /**
     * Mock then test getPassword
     */
    @Test
    public void testUserPassword(){
        User mockedReturner3 = mock(User.class);
        when(mockedReturner3.getPassword()).thenReturn(USER_PASSWORD_TEST);
        assertEquals(mockedReturner3.getPassword(), USER_PASSWORD_TEST);
    }
    /**
     * Mock then test getUserEmail
     */
    @Test
    public void testUserEmail(){
        User mockedReturner3 = mock(User.class);
        when(mockedReturner3.getUserEmail()).thenReturn(USER_EMAIL_TEST);
        assertEquals(mockedReturner3.getUserEmail(), USER_EMAIL_TEST);
    }

    @Test
    public void testChangeUserEmail(){
        String changedEmail = "ChangedEmail@MockitoTest.com";
        User mockedReturner4 = new User("f", "f", "f");
        mockedReturner4.setUserEmail(changedEmail);
        assertEquals(changedEmail, mockedReturner4.getUserEmail());
    }

}
