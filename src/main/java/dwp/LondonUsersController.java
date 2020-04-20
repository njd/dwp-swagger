package dwp;

import dwp.model.User;
import dwp.model.UserList;
import dwp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LondonUsersController {
    private static final Logger logger = LoggerFactory.getLogger(LondonUsersController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/london/users")
    public List<User> getLondonUsers() {

        List<User> users = new ArrayList<>();

        UserList londonUsers = UserService.getUserList().nearLondon();

        return londonUsers.getUsers();
    }

}
