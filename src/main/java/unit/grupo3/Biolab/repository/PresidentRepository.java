package unit.grupo3.Biolab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.PresidentEntity;

import java.util.Optional;

public interface PresidentRepository extends JpaRepository <PresidentEntity,Long>{

    boolean existsByResearcherId(Long researcherId);
    PresidentEntity getByResearcherId(Long researcherId);
}
