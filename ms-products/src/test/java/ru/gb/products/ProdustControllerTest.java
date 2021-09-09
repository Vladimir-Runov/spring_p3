package ru.gb.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class ProdustControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    private void getAllProductsTest() throws Exception {

            this.mvc.perform(get("/api/v1/products").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$.content").isArray())
                    .andExpect(jsonPath("$.content".hasSize(3)))
                    .andExpect(jsonPath("$.content[0].title", is("Bread")));


    }
}
