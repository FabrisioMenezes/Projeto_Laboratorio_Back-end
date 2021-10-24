package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.service.PresidentService;
import unit.grupo3.Biolab.model.PresidentEntity;


@RestController
@CrossOrigin
@RequestMapping("/president")

public class PresidentController {
    
    @Autowired
    private PresidentService presidentService;

    @GetMapping
    ResponseEntity getRegisteredPresident(@RequestParam(value = "researcherId") Long researcherId){
        return presidentService.getRegisteredPresident(researcherId);

    }

    @PostMapping
    ResponseEntity createPresident(@RequestBody PresidentEntity presidentEntity){
        return presidentService.createPresident(presidentEntity);
    }

    @DeleteMapping("/{researcherID}")
    ResponseEntity deletePresident(@PathVariable Long researcherId){
        return presidentService.deletePresident(researcherId);
    }

    @PatchMapping
    ResponseEntity updatePresident(@RequestBody PresidentEntity presidentEntity){
        return presidentService.updatePresident(presidentEntity);
    }



}
