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

import unit.grupo3.Biolab.model.AreaOfInterestEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional

@Sql({"/AreaOfInterestControllerTest.sql"})
public class AreaOfInterestControllerTest {
    
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreateAreaOfInterest() throws Exception{
        AreaOfInterestEntity areaOfInterestEntity = new AreaOfInterestEntity("Area","Area2");

        mvc.perform(post("/areaofinterest")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(areaOfInterestEntity)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test 
    void shouldHaveErrorWhenCreateSpecieWithExist() throws Exception{
        AreaOfInterestEntity areaOfInterestEntity = new AreaOfInterestEntity("Area of Interest 1","Area of Interest 1");

        mvc.perform(post("/areaofinterest")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(areaOfInterestEntity)))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void shouldGetRegisteredAreaOfInterest() throws Exception{
        String name = "Area of Interest 1";

        mvc.perform(get("/areaofinterest/" + name))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", equalTo(name)))
            .andReturn();
    }

    @Test
    void shouldHaveErrorWhenGetNotRegisteredAreaOfInterest() throws Exception{
        String name = "Area of Interest 2";

        mvc.perform(get("/areaofinterest/" + name))
            .andExpect(status().isNotFound())
            .andReturn();
    }
}
