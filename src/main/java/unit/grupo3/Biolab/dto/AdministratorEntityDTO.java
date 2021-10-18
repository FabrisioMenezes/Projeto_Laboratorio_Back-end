package unit.grupo3.Biolab.dto;

import unit.grupo3.Biolab.model.AdministratorEntity;

public class AdministratorEntityDTO {
    
    private String name;
    private String email;
    private Boolean active;
    

    public AdministratorEntityDTO(){

    }

    public AdministratorEntityDTO(String name, String email, Boolean active){
        this.name = name;
        this.email = email;
        this.active = active;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public Boolean getActive() {
        return active;
    }

    
    public void converter(AdministratorEntity administratorEntity){
        name = administratorEntity.getName();
        email = administratorEntity.getEmail();
        active = administratorEntity.getActive();
    }

    
}
