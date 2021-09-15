package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

    public ResearcherEntity() {
    }

    public ResearcherEntity(String name, String email, String password, Integer matriculation, String areaOfInterest, String curriculumLink) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.matriculation = matriculation;
        this.areaOfInterest = areaOfInterest;
        this.curriculumLink = curriculumLink;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(Integer matriculation) {
        this.matriculation = matriculation;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public String getCurriculumLink() {
        return curriculumLink;
    }

    public void setCurriculumLink(String curriculumLink) {
        this.curriculumLink = curriculumLink;
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
                '}';
    }
}
