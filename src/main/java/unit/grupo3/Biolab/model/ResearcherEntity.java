package unit.grupo3.Biolab.model;

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
