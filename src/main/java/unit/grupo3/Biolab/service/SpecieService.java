package unit.grupo3.Biolab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unit.grupo3.Biolab.model.SpecieEntity;
import unit.grupo3.Biolab.repository.SpecieRepository;
import unit.grupo3.Biolab.service.error.ApiError;



@Service
public class SpecieService {
    
    @Autowired
    private SpecieRepository repository;

    public ResponseEntity getSpecies(){
        
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
        
    }

    public ResponseEntity getSpecie(String name){
        
        boolean existsSpecie = repository.existsByName(name);

        if(existsSpecie){
            SpecieEntity specieEntity = repository.getByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(specieEntity);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma specie cadastrada com esse nome"));
    }

    public ResponseEntity createSpecie(SpecieEntity specieEntity){
        
        boolean existSpecie = repository.existsByName(specieEntity.getName());

        if(existSpecie){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Já existe uma specie criada com esse nome!"));
        }

        repository.save(specieEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
        
    }

    public ResponseEntity updateSpecie(String name,SpecieEntity specieEntity){
        
        boolean existSpecie = repository.existsByName(name);

        if(existSpecie){
            SpecieEntity oldSpecieEntity = repository.getByName(name);
            oldSpecieEntity.update(specieEntity);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma especie com esse nome!"));
    }

    public ResponseEntity deleteSpecie(String name){
        boolean existSpecie = repository.existsByName(name);

        if(existSpecie){
            SpecieEntity entity = repository.getByName(name);
            repository.deleteById(entity.getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Não existe nenhuma especie com nome!"));
    }
}
