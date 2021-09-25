package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.ResearcherEntity;
import unit.grupo3.Biolab.repository.ResearcherRepository;
import unit.grupo3.Biolab.service.error.ApiError;

import java.util.Optional;

@Service
public class ResearcherService {

    @Autowired
    private ResearcherRepository repository;

    public ResponseEntity getRegisteredResearcher(String email, String password){

        Optional<ResearcherEntity> researcherEntityOptional = repository.findByEmailAndPassword(email, password);

        if (researcherEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Pesquisador não encontrado."));
    }

    public ResponseEntity createResearcher(ResearcherEntity researcherEntity){

        String email = researcherEntity.getEmail();
        boolean alreadyExist = repository.existsByEmail(email);

        if (!alreadyExist) {
            repository.save(researcherEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Email já cadastrado."));
    }
}
