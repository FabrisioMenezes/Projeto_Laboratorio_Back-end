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

        Optional <AdministratorEntity> administratorEntityOptional = repository.findByEmailAndPassword(email,password);

        if(administratorEntityOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(administratorEntityOptional);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Administrador não encontrado!"));
    }

    public ResponseEntity createAdministrator(AdministratorEntity administratorEntity){

        boolean existAdministrator = repository.existsByEmail(administratorEntity.getEmail());

        if(existAdministrator){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Já existe um administrador criado com esse email!"));
        }

        repository.save(administratorEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }


    public ResponseEntity getAdministratorData(String email){

        boolean existAdministrator = repository.existsByEmail(email);

        if(existAdministrator){
            AdministratorEntity administratorEntity = repository.getByEmail(email);
            AdministratorEntityDTO administratorEntityDTO = new AdministratorEntityDTO();
            administratorEntityDTO.converter(administratorEntity);
            return ResponseEntity.status(HttpStatus.OK).body(administratorEntityDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
    }

    public ResponseEntity updateAdministrator(String email,AdministratorEntity administratorEntity){

        boolean existAdministrator = repository.existsByEmail(email);

        if(existAdministrator){
            AdministratorEntity oldAdministrator = repository.getByEmail(email);
            oldAdministrator.update(administratorEntity);
            repository.save(oldAdministrator);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe administrador cadastrado com esse email"));

    }   

    public ResponseEntity deleteAdministrator(String email){

        boolean existADministrator = repository.existsByEmail(email);

        if(existADministrator){
            AdministratorEntity administratorEntity = repository.getByEmail(email); 
            repository.deleteById(administratorEntity.getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError ("Não existe administrador cadastrado com esse email"));
    }


}   
