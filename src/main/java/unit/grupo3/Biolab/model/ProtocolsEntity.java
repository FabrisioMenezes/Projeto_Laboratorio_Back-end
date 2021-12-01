package unit.grupo3.Biolab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import unit.grupo3.Biolab.utils.CurrentDateFormatted;
import unit.grupo3.Biolab.utils.ProtocolsStatus;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "PROTOCOLS")
public class ProtocolsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer matriculation;
    private ProtocolsStatus status;
    private String review;
    private Boolean seemCommission;
    private Boolean seemPresident;
    private final String creationDate = new CurrentDateFormatted().getDate();
    private String seemDate;
    private Long speciesId;
    private Integer quantitySpecies;
    private Integer presidentMatriculation;
    private Integer firstResearcherMatriculation;
    private Integer secondResearcherMatriculation;
    private Integer thirdResearcherMatriculation;
    private Boolean firstSeem;
    private Boolean secondSeem;
    private Boolean thirdSeem;
    private Long areaId;

    public ProtocolsEntity() {
    }

    public ProtocolsEntity(String title, Integer matriculation, ProtocolsStatus status, String review, Boolean seemCommission, Boolean seemPresident,String seemDate, Long speciesId, Integer quantitySpecies,Integer presidentMatriculation,Integer firstReseacherMatriculation,Integer secodenReseacherMatriculation, Integer thirdReseacherMatriculation ,Boolean firstSeem, Boolean secondSeem, Boolean thirdSeem, Long areaId) {
         this.areaId = areaId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getMatriculation() {
        return matriculation;
    }

    public ProtocolsStatus getStatus() {
        return status;
    }

    public String getReview() {
        return review;
    }

    public Boolean getSeemCommission() {
        return seemCommission;
    }

    public Boolean getSeemPresident() {
        return seemPresident;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getSeemDate() {
        return seemDate;
    }

    public Long getSpeciesId() {
        return speciesId;
    }

    public Integer getQuantitySpecies() {
        return quantitySpecies;
    }

    public Integer getPresidentMatriculation() {
        return presidentMatriculation;
    }
    public Integer getFirstResearcherMatriculation() {
        return firstResearcherMatriculation;
    }
    
    public Integer getSecondResearcherMatriculation() {
        return secondResearcherMatriculation;
    }

    public Integer getThirdResearcherMatriculation() {
        return thirdResearcherMatriculation;
    }

    public Boolean getFirstSeem() {
        return firstSeem;
    }

    public Boolean getSecondSeem() {
        return secondSeem;
    }

    public Boolean getThirdSeem() {
        return thirdSeem;
    }

    public Long getAreaId() {
        return areaId;
    }

    @Override
    public String toString() {
        return "ProtocolsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", matriculation=" + matriculation +
                ", status=" + status +
                ", review='" + review + '\'' +
                ", seemCommission=" + seemCommission +
                ", seemPresident=" + seemPresident +
                ", creationDate=" + creationDate +
                ", seemDate=" + seemDate +
                ", speciesId=" + speciesId +
                ", quantitySpecies=" + quantitySpecies +
                ", firstReseacherId=" + firstResearcherMatriculation +
                ", secodenReseacherId=" + secondResearcherMatriculation +
                ", thirdReseacherId=" + thirdResearcherMatriculation +
                ", firstSeem=" + firstSeem +
                ", secondSeem=" + secondSeem +
                ", thirdSeem=" + thirdSeem +
                ", areaId=" + areaId +
                '}';
    }
}