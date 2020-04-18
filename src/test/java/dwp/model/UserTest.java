package dwp.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testToString() {
        User user = new User();

        user.setId(1L);
        user.setFirstName("Joe");
        user.setLastName("User");
        user.setEmail("joe@some.where");
        user.setIpAddress("1.1.1.1");
        user.setLatitude(51.5074);
        user.setLongitude(0.1278);

        String expectedString = "User{"
                              + "id=1, firstName=Joe, lastName=User, email=joe@some.where, "
                              + "ipAddress=1.1.1.1, inetAddress=/1.1.1.1, "
                              + "lat/lon=(51.5074,0.1278)"
                              + "}";
        assertEquals(expectedString, user.toString());
    }
}