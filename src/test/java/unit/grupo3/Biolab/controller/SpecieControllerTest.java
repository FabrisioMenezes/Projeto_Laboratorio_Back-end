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

import unit.grupo3.Biolab.model.SpecieEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional

@Sql({"/SpecieControllerTest.sql"})

public class SpecieControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;    

    @Test
    void shouldCreateSpecie() throws Exception{
        SpecieEntity specieEntity = new SpecieEntity("Jacare",10);

        mvc.perform(post("/species")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(specieEntity)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test 
    void shouldHaveErrorWhenCreateSpecieWithNameExist() throws Exception{
        SpecieEntity specieEntity = new SpecieEntity("macaco",10);

        mvc.perform(post("/species")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(specieEntity)))
            .andExpect(status().isBadRequest())
            .andReturn();
        }
    

    @Test
    void shouldGetSpecieByName() throws Exception{
        mvc.perform(get("/species/macaco"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(1)))
            .andExpect(jsonPath("$.name", equalTo("macaco")))
            .andReturn();
    }

    @Test
    void shouldHaveErrorWhenGetInexistentSpecieByName() throws Exception{
        mvc.perform(get("/species/jacare"))
            .andExpect(status().isNotFound())
            .andReturn();
    }
}
