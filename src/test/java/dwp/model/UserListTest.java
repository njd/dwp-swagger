package dwp.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UserListTest {

    User user1;
    User user2;

    UserList emptyList;
    UserList listOfOne;
    UserList listOfTwo;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1L, "Forename", "Surname", 0.0, 0.0);
        user2 = new User(2L, "User", "Two", 0.0, 0.0);

        emptyList = new UserList();
        listOfOne = new UserList(Arrays.asList(user1));
        listOfTwo = new UserList(Arrays.asList(user1, user2));
    }

    @Test
    public void getUsers() {
    }

    @Test
    public void setUsers() {
    }

    @Test
    public void testToStringWhenEmpty() {
        assertEquals("", emptyList.toString());
    }

    @Test
    public void testToStringWhenOne() {
        assertEquals(user1.toString(), listOfOne.toString());
    }

    @Test
    public void testToStringWhenTwo() {
        assertEquals(user1.toString() + ", " + user2.toString(), listOfTwo.toString());
    }

    @Test
    public void sizeWhenEmpty() {
        assertEquals(0, emptyList.size());
    }

    @Test
    public void sizeWhenOne() {
        assertEquals(1, listOfOne.size());
    }

    @Test
    public void sizeWhenTwo() {
        assertEquals(2, listOfTwo.size());
    }
}