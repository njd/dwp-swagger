package dwp.service;

import dwp.model.User;
import dwp.model.UserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static UserList getUserList() {
        String usersURL = "https://bpdts-test-app.herokuapp.com/"
            + "users";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> usersResponse = restTemplate.exchange(usersURL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<User>>() {
            });

        UserList userList = new UserList(usersResponse.getBody());

        logger.info("Returning a list of {} users", userList.size());
        return userList;
    }
}