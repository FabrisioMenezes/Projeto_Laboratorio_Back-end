package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.dto.ResearcherEntityDTO;
import unit.grupo3.Biolab.model.ResearcherEntity;

import java.util.List;
import java.util.Optional;

public interface ResearcherRepository extends JpaRepository<ResearcherEntity, Long> {
    Optional<ResearcherEntity> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    boolean existsByIsPresident(Boolean status);
    ResearcherEntity getByMatriculation(Integer matriculation);
    List<ResearcherEntity> getByActive(Boolean active);
    boolean existsByMatriculation(Integer matriculation);
    void deleteByMatriculation(Integer matriculation);
}
