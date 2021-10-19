package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.model.AnalystCommissionEntity;
import unit.grupo3.Biolab.service.AnalystCommissionService;

@RestController
@CrossOrigin
@RequestMapping("/analystcommision")
public class AnalystCommissionController {
    
    @Autowired
    private AnalystCommissionService analystCommisionService;

    @GetMapping
    public ResponseEntity getRegisteredAnalystCommission(@RequestParam(value = "protocolId") Long protocolId){
        return analystCommisionService.getRegisteredAnalystCommission(protocolId);
    }

    @PostMapping
    public ResponseEntity createAnalystComission(@RequestBody AnalystCommissionEntity analystCommisionEntity){
        return analystCommisionService.createAnalystComission(analystCommisionEntity);
    }

    @PatchMapping
    public ResponseEntity updateAnalystComission(@RequestBody AnalystCommissionEntity analystCommisionEntity ){
        return analystCommisionService.updateAnalystCommision(analystCommisionEntity);
    }

    @DeleteMapping
    public ResponseEntity deleteAnalystComission(@RequestParam(value="protocolId") Long protocolId){
        return analystCommisionService.deleteAnalystCommision(protocolId);
    }

}
