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

import java.sql.Date;

import unit.grupo3.Biolab.model.PresidentEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional


@Sql({"/PresidentControllerTest.sql"})
public class PresidentControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreatePresident() throws Exception{
        Date dateNow = new Date(System.currentTimeMillis());
        PresidentEntity PresidentEntity = new PresidentEntity(4l,dateNow,dateNow,true);

        mvc.perform(post("/president")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(PresidentEntity)))
        .andExpect(status().isCreated())
        .andReturn();
    }

    @Test
    void shouldHaveErrorWhenCreateSpecieWithIdExist() throws Exception{
        Date dateNow = new Date(System.currentTimeMillis());
        PresidentEntity PresidentEntity = new PresidentEntity(1l,dateNow,dateNow,true);

        mvc.perform(post("/president")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(PresidentEntity)))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void shouldGetRegisteredAdministrators() throws Exception{

        Long reseacherId = 1l;

        mvc.perform(get("/president?researcherId="+reseacherId))
        .andExpect(status().isOk())
        .andReturn();
    }

    @Test
    void shouldHaveErrorWhenTryGetUnregisteredPresident() throws Exception{
        Long reseacherId = 2l;

        mvc.perform(get("/president?researcherId="+reseacherId))
        .andExpect(status().isNotFound())
        .andReturn();
    }
}
