package unit.grupo3.Biolab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.ProtocolsEntity;
import unit.grupo3.Biolab.utils.ProtocolsStatus;

import java.util.List;

public interface ProtocolsRepository extends JpaRepository<ProtocolsEntity, Long> {
    List<ProtocolsEntity> getByStatus(ProtocolsStatus status);
    ArrayList<ProtocolsEntity> findAll();
    List<ProtocolsEntity> getByMatriculation(Integer matriculation);
}
