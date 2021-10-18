package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.dto.SecretaryEntityDTO;
import unit.grupo3.Biolab.model.SecretaryEntity;
import unit.grupo3.Biolab.repository.SecretaryRepository;
import unit.grupo3.Biolab.service.error.ApiError;

import java.util.Optional;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository repository;

    public ResponseEntity getRegisteredSecretary(String email, String password) {

        Optional<SecretaryEntity> secretaryEntityOptional = repository.findByEmailAndPassword(email, password);

        if (secretaryEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(secretaryEntityOptional.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Secretaria não existente"));
    }

    public ResponseEntity createSecretary(SecretaryEntity secretaryEntity) {

        String email = secretaryEntity.getEmail();

        boolean alreadyExistEmail = repository.existsByEmail(email);
        if (alreadyExistEmail) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Email já cadastrado"));
        }
        repository.save(secretaryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public ResponseEntity updateSecretary(SecretaryEntity secretaryEntity) {
        boolean existsSecretary = repository.existsByEmail(secretaryEntity.getEmail());

        if (existsSecretary) {
            SecretaryEntity oldSecretaryEntity = repository.getByEmail(secretaryEntity.getEmail());
            oldSecretaryEntity.update(secretaryEntity);
            repository.save(oldSecretaryEntity);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError("Não existe nenhuma secretaria com este email"));

    }

    public ResponseEntity deleteSecretary(String email) {
        boolean existSecretary = repository.existsByEmail(email);

        if(existSecretary){
            SecretaryEntity secretaryEntity = repository.getByEmail(email);
            repository.deleteById(secretaryEntity.getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma secretária com este email!"));
    }

    public ResponseEntity getSecretaryData(String email) {
        boolean existSecretary = repository.existsByEmail(email);
        
        if (existSecretary) {
            SecretaryEntity secretaryEntity = repository.getByEmail(email);
            SecretaryEntityDTO secretaryEntityDTO = new SecretaryEntityDTO();
            secretaryEntityDTO.converter(secretaryEntity);
            return ResponseEntity.status(HttpStatus.OK).body(secretaryEntityDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma secretária com esse email!"));

    }
}
