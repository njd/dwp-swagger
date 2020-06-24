package dwp.controller.api;

import dwp.model.User;
import dwp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LondonUsersRestController {
    private static final Logger logger = LoggerFactory.getLogger(LondonUsersRestController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/london/users")
    public List<User> getLondonUsers() {

        List<User> londonUsers = userService.getUsersInOrNearLondon();
        logger.info("Returning {} London users", londonUsers.size());

        return londonUsers;
    }

}
