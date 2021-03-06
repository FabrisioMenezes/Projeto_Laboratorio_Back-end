package unit.grupo3.Biolab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.grupo3.Biolab.model.ProtocolsEntity;
import unit.grupo3.Biolab.service.ProtocolsService;

@RestController
@CrossOrigin
@RequestMapping("/protocols")
public class ProtocolsController {

    @Autowired
    private ProtocolsService protocolsService;

    @PostMapping
    public ResponseEntity createProtocol(@RequestBody ProtocolsEntity protocolsEntity) {
        return protocolsService.createProtocol(protocolsEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProtocol(@PathVariable Long id) {
        return protocolsService.getProtocolData(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProtocol(@PathVariable Long id) {
        return protocolsService.deleteProtocol(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity getByStatus(@PathVariable int status) {
        return protocolsService.getProtocolsByStatus(status);
    }

    @GetMapping("/matriculation/{matriculation}")
    public ResponseEntity getByMatriculation(@PathVariable Integer matriculation) {
        return protocolsService.getProtocolsByMatriculation(matriculation);
    }

    @GetMapping
    public ResponseEntity getProtocols() {
        return protocolsService.getProtocols();
    }

    @GetMapping("/reseacher/{matriculation}")
    public ResponseEntity getProtocolsByMatriculationReseacher(@PathVariable Integer matriculation) {
        return protocolsService.getProtocolsByMatriculationReseacher(matriculation);
    }

}
