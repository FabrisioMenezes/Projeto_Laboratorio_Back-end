package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unit.grupo3.Biolab.model.ResearcherEntity;
import unit.grupo3.Biolab.repository.ResearcherRepository;
import unit.grupo3.Biolab.service.ResearcherService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/researchers")
public class ResearcherController {

    @Autowired
    private ResearcherService researcherService;

    @GetMapping
    ResponseEntity getRegisteredResearcher(@RequestParam(value = "email") String email,
                                           @RequestParam(value = "password") String password){

        return researcherService.getRegisteredResearcher(email, password);
    }

    @PostMapping
    ResponseEntity createResearcher(@RequestBody ResearcherEntity researcherEntity){

        return researcherService.createResearcher(researcherEntity);
    }

}
