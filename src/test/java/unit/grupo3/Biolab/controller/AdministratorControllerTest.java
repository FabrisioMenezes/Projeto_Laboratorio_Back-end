package unit.grupo3.Biolab.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import unit.grupo3.Biolab.model.AdministratorEntity;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional
@Sql({"/AdministratorControllerTest.sql"})
public class AdministratorControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreateResearcher() throws Exception {

        AdministratorEntity administratorEntity = new AdministratorEntity("ismael","ismael","1234",true);
        
        mvc.perform(post("/administrator")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(administratorEntity)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    void shouldNotCreateResearcherBecauseAlreadyExistEmail() throws Exception {

        AdministratorEntity administratorEntity = new AdministratorEntity("ismael","ismael@gmail.com","1234",true);
        
        mvc.perform(post("/administrator")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(administratorEntity)))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void shouldGetRegisteredAdministrators() throws Exception {
        String email = "ismael@gmail.com";
        String password = "12345";

        mvc.perform(get("/administrator?email=" + email + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", equalTo(email)))
                .andExpect(jsonPath("$.password", equalTo(password)))
                .andReturn();

    }

    @Test
    void shouldHaveErrorWhenTryGetUnregisteredAdministrator() throws Exception {
        String email = "teste@gmail.com";
        String password = "12345";

        mvc.perform(get("/administrator?email=" + email + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
