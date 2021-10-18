package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.model.AdministratorEntity;
import unit.grupo3.Biolab.dto.AdministratorEntityDTO;
import unit.grupo3.Biolab.service.AdministratorService;


@RestController
@CrossOrigin
@RequestMapping("/administrator")

public class AdministratorController {
    
    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    ResponseEntity getRegisteredAdministrator(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password){
        return administratorService.getRegisteredAdministrator(email,password);
    }

    @PostMapping
    ResponseEntity createAdministrator(@RequestBody AdministratorEntity administratorEntity){
        return administratorService.createAdministrator(administratorEntity);
    }

    @GetMapping("/{email}")
    ResponseEntity <AdministratorEntityDTO> getAdministratorData(@PathVariable String email){
        return administratorService.getAdministratorData(email);
    }

    @PatchMapping("/{email}")
    ResponseEntity updateAdministrator(@PathVariable String email,@RequestBody AdministratorEntity administratorEntity){
        return administratorService.updateAdministrator(email ,administratorEntity);
    }

    @DeleteMapping("/{email}")
    ResponseEntity deleteAdministrator(@PathVariable String email){
        return administratorService.deleteAdministrator(email);
    }
}   
