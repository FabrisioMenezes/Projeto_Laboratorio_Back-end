package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.dto.ResearcherEntityDTO;
import unit.grupo3.Biolab.model.ResearcherEntity;
import unit.grupo3.Biolab.service.ResearcherService;

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

    @GetMapping("/{matriculation}")
    ResponseEntity<ResearcherEntityDTO> getResearcherData(@PathVariable Integer matriculation) {
        return researcherService.getResearcherData(matriculation);
    }

    @PatchMapping("/{matriculation}")
    ResponseEntity updateResearcher(@PathVariable Integer matriculation, @RequestBody ResearcherEntity newResearcher) {
        return researcherService.updateResearcher(matriculation, newResearcher);
    }

    @DeleteMapping("/{matriculation}")
    ResponseEntity deleteResearcher(@PathVariable Integer matriculation) {
        return researcherService.deleteResearcher(matriculation);
    }

    @GetMapping("/actives")
    ResponseEntity getResearchers() {
        return researcherService.getActiveResearchers();
    }

    @GetMapping("/email/{email}")
    ResponseEntity getExistsReseacher(@PathVariable String email){
        return researcherService.exitsByEmail(email);
    }

}
