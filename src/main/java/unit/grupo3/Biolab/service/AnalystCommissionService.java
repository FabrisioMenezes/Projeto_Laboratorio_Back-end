package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.AnalystCommissionEntity;
import unit.grupo3.Biolab.repository.AnalystCommissionRepository;
import unit.grupo3.Biolab.service.error.ApiError;

@Service
public class AnalystCommissionService {

    @Autowired
    private AnalystCommissionRepository repository;

    public ResponseEntity getRegisteredAnalystCommission(Long protocolId) {

        boolean existsAnalystCommission = repository.existsByProtocolId(protocolId);

        if (existsAnalystCommission) {
            AnalystCommissionEntity analystCommisionEntity = repository.getByProtocolId(protocolId);
            return ResponseEntity.status(HttpStatus.OK).body(analystCommisionEntity);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma comissão de analista com esse ID"));
    }

    public ResponseEntity createAnalystComission(AnalystCommissionEntity analystCommisionEntity) {

        boolean existsAnalystCommission = repository.existsByProtocolId(analystCommisionEntity.getProtocolId());

        if (existsAnalystCommission) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Comissão de analista já criada"));
        }
        repository.save(analystCommisionEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    public ResponseEntity deleteAnalystCommision(Long protocolId) {

        boolean existsAnalystCommission = repository.existsByProtocolId(protocolId);

        if (existsAnalystCommission) {
            AnalystCommissionEntity analystCommissionEntity = repository.getByProtocolId(protocolId);
            repository.deleteById(analystCommissionEntity.getId());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError("Não existe comissão de analista com esse protocolo"));
    }

    public ResponseEntity updateAnalystCommision(AnalystCommissionEntity analystCommisionEntity) {

        boolean existsAnalystCommission = repository.existsByProtocolId(analystCommisionEntity.getProtocolId());

        if (existsAnalystCommission) {
            AnalystCommissionEntity oldAnalystCommission = repository.getByProtocolId(analystCommisionEntity.getProtocolId());
            oldAnalystCommission.update(analystCommisionEntity);
            repository.save(oldAnalystCommission);
            return ResponseEntity.status(HttpStatus.OK).body(analystCommisionEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma comissão de analista com esse ID"));
    }
}
