package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "PROTOCOLS")
public class ProtocolsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer matriculation;
    private Integer status;
    private String review;
    private Boolean seemComission;
    private Boolean seemPresident;
    private Date creationDate;
    private Date seemDate;
    private Long speciesId;
    private Integer quantitySpecies;
    private Boolean firstSeem;
    private Boolean secondSeem;
    private Boolean thirdSeem;
    private Long areaId;

    public ProtocolsEntity(){

    }
    public ProtocolsEntity(String title, Integer matriculation, Integer status, String review, Boolean seemComission, Boolean seemPresident, Date creationDate, Date seemDate, Long speciesId, Integer quantitySpecies, Boolean firstSeem, Boolean secondSeem, Boolean thirdSeem, Long areaId){
        this.title = title;
        this.matriculation = matriculation;
        this.status = status;
        this.review = review;
        this.seemComission = seemComission;
        this.seemPresident = seemPresident;
        this.creationDate = creationDate;
        this.seemDate = seemDate;
        this.speciesId = speciesId;
        this.quantitySpecies = quantitySpecies;
        this.firstSeem = firstSeem;
        this.secondSeem = secondSeem;
        this.thirdSeem = thirdSeem;
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

    public Integer getStatus() {
        return status;
    }

    public String getReview() {
        return review;
    }

    public Boolean getSeemComission() {
        return seemComission;
    }

    public Boolean getSeemPresident() {
        return seemPresident;
    }
 
    public Date getCreationDate() {
        return creationDate;
    }
  
    public Date getSeemDate() {
        return seemDate;
    }
  
    public Long getSpeciesId() {
        return speciesId;
    }
  
    public Integer getQuantitySpecies() {
        return quantitySpecies;
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
    
    @Override
    public String toString() {
        return "ProtocolsEntity [areaId=" + areaId + ", creationDate=" + creationDate + ", firstSeem=" + firstSeem
                + ", id=" + id + ", matriculation=" + matriculation + ", quantitySpecies=" + quantitySpecies
                + ", review=" + review + ", secondSeem=" + secondSeem + ", seemComission=" + seemComission
                + ", seemDate=" + seemDate + ", seemPresident=" + seemPresident + ", speciesId=" + speciesId
                + ", status=" + status + ", thirdSeem=" + thirdSeem + ", title=" + title + "]";
    }
  
    

    
  

    


}
