package unit.grupo3.Biolab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.SpecieEntity;

public interface SpecieRepository extends JpaRepository<SpecieEntity,Long>{
    SpecieEntity getByName(String name);
    boolean existsByName(String name);
    void deleteById(Long Id);
    ArrayList <SpecieEntity> findAll();
}