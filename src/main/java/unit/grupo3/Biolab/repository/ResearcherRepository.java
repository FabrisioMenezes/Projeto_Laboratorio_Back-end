package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.ResearcherEntity;

import java.util.Optional;

public interface ResearcherRepository extends JpaRepository<ResearcherEntity, Long> {
    Optional<ResearcherEntity> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
