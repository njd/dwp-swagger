package dwp.controller;

import dwp.model.User;
import dwp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LondonUsersController {
    private static final Logger logger = LoggerFactory.getLogger(LondonUsersController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/london/users")
    public List<User> getLondonUsers() {

        List<User> londonUsers = userService.getUsersInOrNearLondon();
        logger.info("Returning {} London users", londonUsers.size());

        return londonUsers;
    }

}
