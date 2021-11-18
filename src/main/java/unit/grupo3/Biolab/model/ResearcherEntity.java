package unit.grupo3.Biolab.model;

import unit.grupo3.Biolab.repository.ResearcherRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "RESEARCHER")
public class ResearcherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer matriculation;
    private String areaOfInterest;
    private String curriculumLink;
    private Boolean active = true;
    private Boolean isPresident = false;

    public ResearcherEntity() {
    }

    public ResearcherEntity(String name, String email, String password, Integer matriculation, String areaOfInterest, String curriculumLink, Boolean active, Boolean isPresident) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.matriculation = matriculation;
        this.areaOfInterest = areaOfInterest;
        this.curriculumLink = curriculumLink;
        this.active = active;
        this.isPresident = isPresident;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getMatriculation() {
        return matriculation;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public String getCurriculumLink() {
        return curriculumLink;
    }

    public Boolean getActive(){
        return active;
    }

    public Boolean getIsPresident() {
        return isPresident;
    }

    public void update(ResearcherEntity entity) {
        if (entity.getActive() != null) {
            this.active = entity.getActive();
        }
        if (entity.getEmail() != null) {
            this.email = entity.getEmail();
        }
        if (entity.getPassword() != null) {
            this.password = entity.getPassword();
        }
        if (entity.getName() != null) {
            this.name = entity.getName();
        }
        if (entity.getMatriculation() != null) {
            this.matriculation = entity.getMatriculation();
        }
        if (entity.getAreaOfInterest() != null) {
            this.areaOfInterest = entity.getAreaOfInterest();
        }
        if (entity.getCurriculumLink() != null) {
            this.curriculumLink = entity.getCurriculumLink();
        }
        if (entity.getIsPresident() != null) {
            this.isPresident = entity.getIsPresident();
        }
    }

    @Override
    public String toString() {
        return "ResearcherEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", matriculation=" + matriculation +
                ", areaOfInterest='" + areaOfInterest + '\'' +
                ", curriculumLink='" + curriculumLink + '\'' +
                ", active=" + active +
                ", isPresident=" + isPresident +
                '}';
    }
}
