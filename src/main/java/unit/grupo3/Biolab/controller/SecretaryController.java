package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.dto.SecretaryEntityDTO;
import unit.grupo3.Biolab.model.SecretaryEntity;
import unit.grupo3.Biolab.service.SecretaryService;

@RestController
@CrossOrigin
@RequestMapping("/  ")
public class SecretaryController {
    @Autowired
    private SecretaryService secretaryService;

    @GetMapping
    ResponseEntity getRegisteredSecretary(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password){
        return secretaryService.getRegisteredSecretary(email,password);
    }

    @PostMapping
    ResponseEntity createSecretary(@RequestBody SecretaryEntity secretaryEntity){
        return secretaryService.createSecretary(secretaryEntity);
    }

    @GetMapping("/{email}")
    ResponseEntity <SecretaryEntityDTO> getSecretaryData(@PathVariable String email){
        return secretaryService.getSecretaryData(email);
    }
    
    @PatchMapping
    ResponseEntity updateResearcher(@RequestBody SecretaryEntity secretaryEntity){
        return secretaryService.updateSecretary(secretaryEntity);
    }

    @DeleteMapping("/{email}")
    ResponseEntity deleteSecretary(@PathVariable String email){
        return secretaryService.deleteSecretary(email);
    }
}
