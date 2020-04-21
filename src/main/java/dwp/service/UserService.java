package dwp.service;

import dwp.geo.Position;
import dwp.model.User;
import dwp.model.UserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Component
public class UserService {

    @Autowired
    GeoService geoService;

    public static final double DISTANCE_MILES = 50.0;
    public static final String BASE_URL = "https://bpdts-test-app.herokuapp.com/";
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static UserList getAllUsersList() {
        return getUserList("users");
    }

    public static UserList getLondonUsersList() {
        return getUserList("city/London/users");
    }

    private static UserList getUserList(String api) {
        String usersURL = BASE_URL + api;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> usersResponse = restTemplate.exchange(usersURL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<User>>() {
            });

        UserList userList = new UserList(usersResponse.getBody());

        logger.info("Returning a list of {} users for api \"{}\"", userList.size(), api);
        return userList;
    }

    public UserList nearLondon(List<User> users) {
        return nearLondon(new UserList(users));
    }

    public UserList nearLondon(UserList userList) {

        UserList filteredUsers = new UserList();
        filteredUsers.setUsers(
            userList.getUsers().stream()
                .filter(user -> geoService.milesBetween(
                    geoService.LONDON, new Position(user.getLatitude(), user.getLongitude())
                ) <= DISTANCE_MILES)
                .collect(Collectors.toList())
        );
        return filteredUsers;
    }

    public List<User> getUsersInOrNearLondon() {
        UserList users = getAllUsersList();
        UserList usersNearLondon = nearLondon(users);
        UserList londonUsers = getLondonUsersList();

        List<User> mergedUsers = Stream.of(londonUsers.getUsers(), usersNearLondon.getUsers())
            .flatMap(Collection::stream)
            .collect(collectingAndThen(
                toCollection(() -> new TreeSet<>(comparingLong(User::getId))),
                ArrayList::new));

        return mergedUsers;
    }
}