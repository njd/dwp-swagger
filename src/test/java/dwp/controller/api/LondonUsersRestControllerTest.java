package dwp.controller.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LondonUsersRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getLondonUsers() throws Exception {
        mockMvc.perform(get("/api/london/users"))
            .andExpect(status().isOk());
    }

    @Test
    public void getsEnoughLondonUsers() throws Exception {
        int expectedCount = 9;

        mockMvc.perform(get("/api/london/users"))
            .andExpect(status().isOk())
            .andExpect((content().contentType(MediaType.APPLICATION_JSON_UTF8)))
            .andExpect(jsonPath("$", hasSize(expectedCount)));
    }

    @Test
    public void getsParticularLondonUsers() throws Exception {
        mockMvc.perform(get("/api/london/users"))
            .andExpect(status().isOk())
            .andExpect((content().contentType(MediaType.APPLICATION_JSON_UTF8)))
            .andExpect(jsonPath("$[0].email", is("mboam3q@thetimes.co.uk")));
    }
}