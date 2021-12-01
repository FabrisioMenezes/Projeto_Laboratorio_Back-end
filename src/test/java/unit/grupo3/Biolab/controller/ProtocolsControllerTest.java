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

import unit.grupo3.Biolab.model.ProtocolsEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional


@Sql({"/ProtocolsControllerTest.sql"})

public class ProtocolsControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreateProtocols() throws Exception{

        ProtocolsEntity protocolsEntity = new ProtocolsEntity("Protocols1",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);

        mvc.perform(post("/protocols")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(protocolsEntity)))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void shouldGetProtocols() throws Exception{

        Long protocolsId = 1L;
        mvc.perform(get("/protocols/"+protocolsId))
                .andExpect(status().isOk())
                .andReturn();
    }
       
    
    @Test 
    void shouldHaveErrorWhenGetProtocolsInexistent() throws Exception{
        Long protocolsId = 4L;
        mvc.perform(get("/protocols/"+protocolsId))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
