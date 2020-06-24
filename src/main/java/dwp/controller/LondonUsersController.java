package dwp.controller;

import dwp.model.User;
import dwp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class LondonUsersController {
    private static final Logger logger = LoggerFactory.getLogger(LondonUsersController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/london/users")
    public ModelAndView getLondonUsers(ModelAndView modelAndView) {

        List<User> londonUsers = userService.getUsersInOrNearLondon();
        logger.info("Returning {} London users", londonUsers.size());

        modelAndView.addObject("users", londonUsers);
        modelAndView.setViewName("users");
        return modelAndView;
    }

}
