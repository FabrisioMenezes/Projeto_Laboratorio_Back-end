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
import unit.grupo3.Biolab.model.ResearcherEntity;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJdbc
@AutoConfigureDataJpa
@Transactional
@Sql({"/ResearcherControllerTest.sql"})
public class ResearcherControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreateResearcher() throws Exception {

        ResearcherEntity researcherEntity = new ResearcherEntity("Artur", "artur@unit.com",
                "12345", 12345, "testando", "testando");

        mvc.perform(post("/researchers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(researcherEntity)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    void shouldNotCreateResearcherBecauseAlreadyExistEmail() throws Exception {

        ResearcherEntity researcherEntity = new ResearcherEntity("Artur", "artur-teste@unit.com",
                "12345", 12345, "testando", "testando");

        mvc.perform(post("/researchers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(researcherEntity)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.error", equalTo("Email já cadastrado.")))
            .andReturn();
    }
}
