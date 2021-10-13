package unit.grupo3.Biolab.dto;

import unit.grupo3.Biolab.model.ResearcherEntity;

public class ResearcherEntityDTO {
    private String name;
    private String email;
    private Integer matriculation;
    private String areaOfInterest;
    private String curriculumLink;
    private Boolean active;
    private Boolean isPresident;

    public ResearcherEntityDTO() {
    }

    public ResearcherEntityDTO(String name, String email, Integer matriculation, String areaOfInterest, String curriculumLink, Boolean active, Boolean isPresident) {
        this.name = name;
        this.email = email;
        this.matriculation = matriculation;
        this.areaOfInterest = areaOfInterest;
        this.curriculumLink = curriculumLink;
        this.active = active;
        this.isPresident = isPresident;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    public Boolean getActive() {
        return active;
    }

    public Boolean getPresident() {
        return isPresident;
    }

    public void converter(ResearcherEntity researcherEntity) {
        name = researcherEntity.getName();
        email = researcherEntity.getEmail();
        matriculation = researcherEntity.getMatriculation();
        areaOfInterest = researcherEntity.getAreaOfInterest();
        curriculumLink = researcherEntity.getCurriculumLink();
        active = researcherEntity.getActive();
        isPresident = researcherEntity.getIsPresident();
    }
}
