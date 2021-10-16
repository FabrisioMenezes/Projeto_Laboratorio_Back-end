package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.dto.AdministratorEntityDTO;
import unit.grupo3.Biolab.model.AdministratorEntity;
import unit.grupo3.Biolab.repository.AdministratorRepository;
import unit.grupo3.Biolab.service.error.ApiError;

import java.util.Optional;

@Service
public class AdministratorService {
    
    @Autowired
    private AdministratorRepository repository;

    public ResponseEntity getRegisteredAdministrator(String email, String password){
        
        Optional <AdministratorEntity> administratorEntity = repository.findByEmailAndPassword(email,password);

        if(administratorEntity.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(administratorEntity.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError ("Administrador não cadastrado"));
    }

    public ResponseEntity createAdministrator(AdministratorEntity administratorEntity){

        boolean existAdministrator = repository.existsByEmail(administratorEntity.getEmail());

        if(existAdministrator){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError ("Email já cadastrado"));
        }

        repository.save(administratorEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public ResponseEntity deleteAdministrator(String email){

        boolean existAdministrator = repository.existsByEmail(email);
        
        if(existAdministrator){
            repository.deleteByEmail(email);
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhum administrador cadastrado com esse email!"));
    }
    
    public ResponseEntity updateAdministrator(AdministratorEntity administratorEntity){

        boolean existAdministrator = repository.existsByEmail(administratorEntity.getEmail());

        if(existAdministrator){
            AdministratorEntity oldAdministratorEntity = repository.getByEmail(administratorEntity.getEmail());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhum administrador cadastrado com esse email!"));
    }

    public ResponseEntity getAdministratorData(String email){
        
        boolean existAdministrator = repository.existsByEmail(email);

        if(existAdministrator){
            AdministratorEntity administratorEntity = repository.getByEmail(email);
            AdministratorEntityDTO administratorEntityDTO = new AdministratorEntityDTO();
            administratorEntityDTO.converter(administratorEntity);
            return ResponseEntity.status(HttpStatus.OK).body(administratorEntityDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhum administrador cadastrado com esse email!"));
    }

}   
