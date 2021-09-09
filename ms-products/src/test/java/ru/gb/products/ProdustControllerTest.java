package ru.gb.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class ProdustControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    private void getAllProductsTest() throws Exception {

            mvc.perform(get("/api/v1/products"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .andExpect(status().IsOk());

    }
}
