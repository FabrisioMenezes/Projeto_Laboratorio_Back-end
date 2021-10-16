package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.AdministratorEntity;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository <AdministratorEntity,Long> {
    Optional<AdministratorEntity> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
    AdministratorEntity getByEmail(String email);
}
