package unit.grupo3.Biolab.repository;

import org.checkerframework.checker.nullness.Opt;
import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.PresidentEntity;

import java.util.Optional;

public interface PresidentRepository extends JpaRepository <PresidentEntity,Long>{
    Optional <PresidentEntity> findbyEmailandPassword(String email, String password);
}
