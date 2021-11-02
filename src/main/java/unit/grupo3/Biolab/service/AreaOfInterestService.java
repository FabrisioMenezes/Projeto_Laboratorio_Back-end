package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.AreaOfInterestEntity;
import unit.grupo3.Biolab.repository.AreaOfInterestRepository;

import unit.grupo3.Biolab.service.error.ApiError;


@Service
public class AreaOfInterestService {
    
    @Autowired
    private AreaOfInterestRepository repository;

    public ResponseEntity getAreaOfInterests(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    public ResponseEntity getAreaOfInterest(String name){
        
        boolean existAreaOfInterest = repository.existsByName(name);

        if(existAreaOfInterest){
            AreaOfInterestEntity areaOfInterestEntity = repository.getByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(areaOfInterestEntity);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não foi encontrado nenhuma área de interesse com esse nome!"));
    }

    public ResponseEntity createAreaOfInterest(AreaOfInterestEntity areaOfInterestEntity){

        boolean existAreaOfInterest = repository.existsByName(areaOfInterestEntity.getName());

        if(existAreaOfInterest){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Já existe uma area de interesse cadastrada com esse nome"));
        }

        repository.save(areaOfInterestEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public ResponseEntity deleteAreaOfInterest(String name){

        boolean existAreaOfInterest = repository.existsByName(name);

        if(existAreaOfInterest){
            AreaOfInterestEntity entity = repository.getByName(name);
            repository.deleteById(entity.getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma área de interesse com esse nome!"));
    }

    public ResponseEntity updateAreaOfInterest(AreaOfInterestEntity areaOfInterest){
        
        boolean existAreaOfInterest = repository.existsByName(areaOfInterest.getName());

        if(existAreaOfInterest){
            AreaOfInterestEntity oldAreaOfInterestEntity = repository.getByName(areaOfInterest.getName());
            oldAreaOfInterestEntity.update(areaOfInterest);
            repository.save(oldAreaOfInterestEntity);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma área de interesse com esse nome!"));


    }

    

}
