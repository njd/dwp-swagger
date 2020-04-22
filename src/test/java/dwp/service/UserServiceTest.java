package dwp.service;

import dwp.model.UserList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Autowired
    GeoService geoService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllUsersList() {
    }

    @Test
    public void getLondonUsersList() {
    }

    @Test
    public void nearLondon() {
    }

    @Test
    public void testNearLondon() {
    }

    @Ignore
    @Test
    public void getUsersInOrNearLondon() {
        UserList allUsers = userService.getAllUsersList();
        assertEquals(1000, allUsers.size());
    }
}