package unit.grupo3.Biolab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.AreaOfInterestEntity;

public interface AreaOfInterestRepository extends JpaRepository <AreaOfInterestEntity,Long>{
    
    ArrayList<AreaOfInterestEntity> findAll();
    AreaOfInterestEntity getByName(String name);
    boolean existsByName(String name);

}