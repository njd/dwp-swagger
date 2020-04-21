package dwp;

import dwp.model.UserList;
import dwp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = { "io.swagger","io.swagger.configuration", "dwp", "dwp.service" })
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    UserService userService;

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }

        //TODO: get list of cities
        //      get list of users for each city

        logger.info("Look at me! I'm running!");

        UserList users = userService.getAllUsersList();
        UserList usersNearLondon = userService.nearLondon(users);
        UserList londonUsers = userService.getLondonUsersList();

        logger.info("User list has {} users", users.size());
        logger.info("London users: {}", londonUsers.size());

        londonUsers.getUsers().stream().forEach(user -> {
            logger.info(user.toString());
        });
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Application.class).run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }
    }

}
