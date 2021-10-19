package unit.grupo3.Biolab.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.model.SpecieEntity;
import unit.grupo3.Biolab.service.SpecieService;


@RestController
@CrossOrigin
@RequestMapping("/species")
public class SpecieController {
    
    @Autowired
    private SpecieService specieService;

    @GetMapping
    ResponseEntity getSpecies(){
        return specieService.getSpecies();
    }

    @PostMapping
    ResponseEntity createSpecie(@RequestBody SpecieEntity specieEntity){
        return specieService.createSpecie(specieEntity);
    }

    @GetMapping("/{name}")
    ResponseEntity getSpecie(@PathVariable String name){
        return specieService.getSpecie(name);
    }

    @PatchMapping
    ResponseEntity updateSpecie(@RequestBody SpecieEntity specieEntity){
        return specieService.updateSpecie(specieEntity);
    }

    @DeleteMapping("/{name}")
    ResponseEntity deleteSpecie(@PathVariable String name){
        return specieService.deleteSpecie(name);
    }
    
}
