package unit.grupo3.Biolab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.ProtocolsEntity;

public interface ProtocolsRepository extends JpaRepository<ProtocolsEntity, Long> {
    ArrayList<ProtocolsEntity> findAll();
}
