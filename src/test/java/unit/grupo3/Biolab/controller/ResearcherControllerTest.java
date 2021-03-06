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
@Sql({"/ResearcherControllerTest.sql"})
public class ResearcherControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldCreateResearcher() throws Exception {

        ResearcherEntity researcherEntity = new ResearcherEntity("ismael2","ismael2@gmail.com","12345123",123452,"teste","teste",true,false);
        
        mvc.perform(post("/researchers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(researcherEntity)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    void shouldNotCreateResearcherBecauseAlreadyExistEmail() throws Exception {

        ResearcherEntity researcherEntity = new ResearcherEntity("ismael", "ismael@gmail.com",
                "12345", 12345, "testando", "testando",true, false);

        mvc.perform(post("/researchers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(researcherEntity)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.error", equalTo("Email j?? cadastrado.")))
            .andReturn();
    }

    @Test
    void shouldGetRegisteredResearcher() throws Exception {
        String email = "ismael@gmail.com";
        String password = "12345";

        mvc.perform(get("/researchers?email=" + email + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", equalTo(email)))
                .andExpect(jsonPath("$.password", equalTo(password)))
                .andReturn();
    }

    @Test
    void shouldHaveErrorWhenTryGetUnregisteredResearcher() throws Exception {
        String email = "artur-teste-teste@unit.com";
        String password = "123455";

        mvc.perform(get("/researchers?email=" + email + "&password=" + password)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", equalTo("Pesquisador n??o encontrado.")))
                .andReturn();
    }

    @Test
    void shouldUpdateResearcher() throws Exception {
        String name = "tutu";
        ResearcherEntity newResearcher = new ResearcherEntity();
        newResearcher.setName(name);

        Integer matriculation = 12345;

        mvc.perform(patch("/researchers/" + matriculation)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(newResearcher)))
                .andExpect(status().isOk())
                .andReturn();
    }
}
