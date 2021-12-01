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


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import unit.grupo3.Biolab.model.SecretaryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional
@Sql({"/SecretaryControllerTest.sql"})


public class SecretaryControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreateSecretary() throws Exception{

        SecretaryEntity secretaryEntity = new SecretaryEntity("ismael","ismael2@gmail.com","1234",true);

        mvc.perform(post("/secretarys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(secretaryEntity)))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void shouldNoteCreateSecretaryBecauseEmailAlreadyExists() throws Exception{

        SecretaryEntity secretaryEntity = new SecretaryEntity("ismael","ismael@gmail.com","12345",true);

        mvc.perform(post("/secretarys")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(secretaryEntity)))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test 
    void shouldGetRegisteredSecretary() throws Exception{

        String email = "ismael@gmail.com";
        String password = "123456";
        
        mvc.perform(get("/secretarys"+"?email="+email+"&password="+password)
                .contentType(MediaType.APPLICATION_JSON))            
                .andExpect(status().isOk());
    }

    @Test 
    void shouldHaveErrorWhenTryGetUnregisteredSecretary() throws Exception{
            
            String email = "teste@gmail.com";
            String password = "123456";

            mvc.perform(get("/secretarys"+"?email="+email+"&password="+password)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

}
