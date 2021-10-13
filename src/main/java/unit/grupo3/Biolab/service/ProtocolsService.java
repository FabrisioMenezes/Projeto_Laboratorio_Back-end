package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.ProtocolsEntity;
import unit.grupo3.Biolab.repository.ProtocolsRepository;
import unit.grupo3.Biolab.service.error.ApiError;

@Service
public class ProtocolsService {

    @Autowired
    private ProtocolsRepository protocolsRepository;

    public ResponseEntity createProtocol(ProtocolsEntity protocolsEntity) {
        protocolsRepository.save(protocolsEntity);
        return ResponseEntity.status(HttpStatus.OK).body(protocolsEntity);
    }

    public ResponseEntity getProtocolData(Long id) {
        boolean existsById = protocolsRepository.existsById(id);
        if (existsById) {
            ProtocolsEntity protocolsEntity = protocolsRepository.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(protocolsEntity);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ApiError("Não existe protocolo com este ID"));
    }

}
