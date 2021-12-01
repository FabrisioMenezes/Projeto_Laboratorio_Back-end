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

import unit.grupo3.Biolab.model.AnalystCommissionEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional

@Sql({"/AnalystCommissionControllerTest.sql"})
public class AnalystCommissionControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;


    @Test
    void shouldCreateAnalystCommission() throws Exception{
        Date dateNow = new Date(System.currentTimeMillis());
        AnalystCommissionEntity analystCommissionEntity = new AnalystCommissionEntity(3l, dateNow, 1l,2l,3l);

        mvc.perform(post("/analystcommision")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(analystCommissionEntity)))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void shouldHaveErrorWhenCreateAnalystCommissionExistent() throws Exception{
        Date dateNow = new Date(System.currentTimeMillis());
        AnalystCommissionEntity analystCommissionEntity = new AnalystCommissionEntity(2l, dateNow, 1l,2l,3l);

        mvc.perform(post("/analystcommision")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(analystCommissionEntity)))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void shouldGetAnalystCommission() throws Exception{
        Long protocolId = 2l;

        mvc.perform(get("/analystcommision/?protocolId=" + protocolId))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test 
    void shouldHaveErrorWithGetAnalystCommissionInexistent() throws Exception{
        Long protocolId = 3l;

        mvc.perform(get("/analystcommision/?protocolId=" + protocolId))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}
