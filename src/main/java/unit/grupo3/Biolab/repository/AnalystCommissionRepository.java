package unit.grupo3.Biolab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unit.grupo3.Biolab.model.AnalystCommissionEntity;


public interface AnalystCommissionRepository extends JpaRepository <AnalystCommissionEntity, Long>{
    
    boolean existsByProtocolId(Long protocolId);
    AnalystCommissionEntity getByProtocolId(Long protocolId);

    
}
