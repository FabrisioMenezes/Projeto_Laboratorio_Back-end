package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.SecretaryEntity;
import java.util.Optional;

public interface SecretaryRepository extends JpaRepository <SecretaryEntity,Long> {
    Optional<SecretaryEntity> findByEmailAndPassword(String email, String password);
}
