package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.model.AreaOfInterestEntity;
import unit.grupo3.Biolab.service.AreaOfInterestService;

@RestController
@CrossOrigin
@RequestMapping("/areaofinterest")

public class AreaOfInterestController {
    
    @Autowired
    private AreaOfInterestService areaOfInterestService;

    @GetMapping
    ResponseEntity getAreaOfInterests(){
        return areaOfInterestService.getAreaOfInterests();
    }

    @PostMapping
    ResponseEntity createAreaOfInterest(@RequestBody AreaOfInterestEntity areaOfInterestEntity){
        return areaOfInterestService.createAreaOfInterest(areaOfInterestEntity);
    }

    @GetMapping("/{name}")
    ResponseEntity getAreaOfInterest(@PathVariable String name){
        return areaOfInterestService.getAreaOfInterest(name);
    }

    @PatchMapping()
    ResponseEntity updateAreaOfInterest(@RequestBody AreaOfInterestEntity areaOfInterestEntity){
        return areaOfInterestService.updateAreaOfInterest(areaOfInterestEntity);
    }

    @DeleteMapping("/{name}")
    ResponseEntity deleteAreaOfInterest(@PathVariable String name){
        return areaOfInterestService.deleteAreaOfInterest(name);
    }


}
