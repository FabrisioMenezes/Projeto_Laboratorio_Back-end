package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.PresidentEntity;
import unit.grupo3.Biolab.repository.PresidentRepository;
import unit.grupo3.Biolab.service.error.ApiError;


@Service
public class PresidentService {
    
    @Autowired
    private PresidentRepository repository;

    public ResponseEntity getRegisteredPresident(Long researcherId){
        
        boolean existPresident = repository.existsByResearcherId(researcherId);

        if(existPresident){
            PresidentEntity presidentEntity = repository.getByResearcherId(researcherId);

            return ResponseEntity.status(HttpStatus.OK).body(presidentEntity);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhum Presidente cadastrado nesse sistema"));

    }

    public ResponseEntity createPresident(PresidentEntity presidentEntity){

        boolean existPresident = repository.existsByResearcherId(presidentEntity.getResearcherId());

        if( existPresident){
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Já existe um Presidente cadastrado com esse ID"));
        }

        repository.save(presidentEntity);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public ResponseEntity deletePresident(Long researcherId){
        
        boolean existsPresident = repository.existsByResearcherId(researcherId);

        if(existsPresident){
            
            PresidentEntity presidentEntity =  repository.getByResearcherId(researcherId);

            repository.delete(presidentEntity);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhum Presidente com esse ID"));
    
    }

    public ResponseEntity updatePresident(PresidentEntity presidentEntity){

        boolean existsPresident = repository.existsByResearcherId(presidentEntity.getResearcherId());

        if(existsPresident){
            
            PresidentEntity oldPresidentEntity = repository.getByResearcherId(presidentEntity.getResearcherId());

            oldPresidentEntity.update(presidentEntity);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhum presidente com esse ID"));    }


}
