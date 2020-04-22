package dwp;

import dwp.controller.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private HomeController controller;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}