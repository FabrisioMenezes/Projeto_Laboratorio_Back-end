package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.ProtocolsEntity;

public interface ProtocolsRepository extends JpaRepository<ProtocolsEntity, Long> {
}
