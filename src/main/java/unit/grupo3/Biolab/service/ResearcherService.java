package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.dto.ResearcherEntityDTO;
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
            return ResponseEntity.status(HttpStatus.OK).body(researcherEntityOptional.get().getIsPresident());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Pesquisador não encontrado."));
    }

    public ResponseEntity createResearcher(ResearcherEntity researcherEntity){
        boolean isPresident = researcherEntity.getIsPresident();
        if (isPresident && repository.existsByIsPresident(true)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Já existe um presidente cadastrado."));
        }
        String email = researcherEntity.getEmail();
        boolean alreadyExistEmail = repository.existsByEmail(email);
        if (alreadyExistEmail) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Email já cadastrado."));
        }
        Integer matriculation = researcherEntity.getMatriculation();
        boolean alreadyExistsMatriculation = repository.existsByMatriculation(matriculation);
        if (alreadyExistsMatriculation) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Matrícula já cadastrada."));
        }
        repository.save(researcherEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public ResponseEntity getResearcherData(Integer matriculation) {
        boolean existsResearcher = repository.existsByMatriculation(matriculation);
        if (existsResearcher) {
            ResearcherEntity researcherEntity = repository.getByMatriculation(matriculation);
            ResearcherEntityDTO researcherEntityDTO = new ResearcherEntityDTO();
            researcherEntityDTO.converter(researcherEntity);
            return ResponseEntity.status(HttpStatus.OK).body(researcherEntityDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe pesquisador com esta matricula"));
        }
    }

    public ResponseEntity updateResearcher(Integer matriculation, ResearcherEntity newEntity) {
        boolean existsResearcher = repository.existsByMatriculation(matriculation);
        if (existsResearcher) {
            ResearcherEntity researcherEntity = repository.getByMatriculation(matriculation);
            researcherEntity.update(newEntity);
            boolean existsPresident = repository.existsByIsPresident(true);
            if (existsPresident && newEntity.getIsPresident()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Já existe um presidente"));
            }
            repository.save(researcherEntity);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe pesquisador com esta matricula"));
    }

    public ResponseEntity deleteResearcher(Integer matriculation) {
        boolean existsResearcher = repository.existsByMatriculation(matriculation);
        if (existsResearcher) {
            repository.deleteByMatriculation(matriculation);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe pesquisador com esta matricula"));
    }
}
