package dwp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserList {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserList() {
        this.users = new ArrayList<User>();
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return users.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public UserList nearLondon() {
        UserList filteredUsers = new UserList();
        filteredUsers.setUsers(
            users.stream()
                 .filter(user -> user.milesTo(User.LONDON_LATITUDE, User.LONDON_LONGITUDE) <= 50)
                 .collect(Collectors.toList())
        );
        return filteredUsers;
    }

    public int size() {
        return users.size();
    }
}
