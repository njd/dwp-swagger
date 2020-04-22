package dwp.service;

import dwp.model.User;
import dwp.model.UserList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserServiceTest {

    User user1;
    User user2;
    User user3;

    UserList emptyList;
    UserList listOfOne;
    UserList listOfTwo;
    UserList listOfThree;


    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Autowired
    GeoService geoService;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1L, "In", "London", geoService.LONDON.latitude, geoService.LONDON.longitude);
        user2 = new User(2L, "In", "Elstree", 51.6441, -0.2982);
        user3 = new User(3L, "In", "Leeds", 53.7905,-1.5430);

        emptyList = new UserList();
        listOfOne = new UserList(Arrays.asList(user1));
        listOfTwo = new UserList(Arrays.asList(user1, user2));
        listOfThree = new UserList(Arrays.asList(user1, user2, user3));
    }

    @Test
    public void getAllUsersList() {
    }

    @Test
    public void getLondonUsersList() {
    }

    @Test
    public void nearLondon() {
        UserList result = userService.nearLondon(listOfThree);
        assertEquals(2, result.size());
    }

    @Test
    public void getUsersInOrNearLondon() {
        UserList allUsers = userService.getAllUsersList();
        assertEquals(1000, allUsers.size());
    }
}