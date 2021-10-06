package unit.grupo3.Biolab.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "PRESIDENT")
public class PresidentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long researcherId;
    private Date managementStart;
    private Date managementEnd;
    private Boolean status;

    public PresidentEntity(){

    }

    public PresidentEntity(Long researcherId, Date managementStart, Date managementEnd, Boolean status){
        this.researcherId = researcherId;
        this.managementStart = managementStart;
        this.managementEnd = managementEnd;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getResearcherId() {
        return researcherId;
    }


    public Date getManagementStart() {
        return managementStart;
    }


    public Date getManagementEnd() {
        return managementEnd;
    }


    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PresidentEntity [id=" + id + ", managementEnd=" + managementEnd + ", managementStart=" + managementStart
                + ", researcherId=" + researcherId + ", status=" + status + "]";
    }

    

}
