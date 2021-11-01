package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.ProtocolsEntity;
import unit.grupo3.Biolab.repository.ProtocolsRepository;
import unit.grupo3.Biolab.service.error.ApiError;
import unit.grupo3.Biolab.utils.ProtocolsStatus;

import java.util.List;

@Service
public class ProtocolsService {

    @Autowired
    private ProtocolsRepository protocolsRepository;

    public ResponseEntity createProtocol(ProtocolsEntity protocolsEntity) {
        protocolsRepository.save(protocolsEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(protocolsEntity);
    }

    public ResponseEntity getProtocolData(Long id) {
        boolean existsById = protocolsRepository.existsById(id);
        if (existsById) {
            ProtocolsEntity protocolsEntity = protocolsRepository.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(protocolsEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe protocolo com este ID"));
    }

    public ResponseEntity deleteProtocol(Long id) {
        boolean existsById = protocolsRepository.existsById(id);
        if (existsById) {
            protocolsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe protoco com este ID"));
    }

    public ResponseEntity getProtocolsByStatus(int status) {
        ProtocolsStatus protocolsStatus = convertToEnum(status);
        if (protocolsStatus == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiError("Não existe status com referência ao número " + status));

        List<ProtocolsEntity> protocolsStatusList = protocolsRepository.getByStatus(protocolsStatus);
        if (protocolsStatusList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe protocolo com o status " + protocolsStatus));
        }
        return ResponseEntity.status(HttpStatus.OK).body(protocolsStatusList);
    }

    private ProtocolsStatus convertToEnum(int status) {
        if (status == 0) return ProtocolsStatus.PENDING;
        if (status == 1) return ProtocolsStatus.ANALYSING;
        if (status == 2) return ProtocolsStatus.APPROVED;
        if (status == 3) return ProtocolsStatus.REPROVED;
        return null;
    }

}