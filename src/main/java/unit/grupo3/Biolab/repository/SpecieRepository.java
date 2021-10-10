package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.SpecieEntity;

public interface SpecieRepository extends JpaRepository<SpecieEntity,Long>{
    
}