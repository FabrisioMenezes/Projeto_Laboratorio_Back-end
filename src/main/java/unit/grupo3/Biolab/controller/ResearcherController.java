package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unit.grupo3.Biolab.model.ResearcherEntity;
import unit.grupo3.Biolab.repository.ResearcherRepository;

import java.util.Optional;

@RestController
@RequestMapping("/researchers")
public class ResearcherController {

    @Autowired
    private ResearcherRepository repository;

    @GetMapping
    ResponseEntity getRegisteredResearcher(@RequestParam(value = "email") String email,
                                           @RequestParam(value = "password") String password){

        Optional<ResearcherEntity> researcherEntityOptional = repository.findByEmailAndPassword(email, password);

        if (researcherEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    ResponseEntity createResearcher(@RequestBody ResearcherEntity researcherEntity){
        
        repository.save(researcherEntity);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
