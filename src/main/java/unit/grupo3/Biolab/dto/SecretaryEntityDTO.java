package unit.grupo3.Biolab.dto;

import unit.grupo3.Biolab.model.SecretaryEntity;


public class SecretaryEntityDTO {
    
    private String name;
    private String email;
    private Boolean active;

    public SecretaryEntityDTO(){

    }

    public SecretaryEntityDTO(String name, String email, Boolean active){
        this.name = name;
        this.email = email;
        this.active = active;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public Boolean getActive(){
        return active;
    }

    public void converter(SecretaryEntity secretEntity){
        name = secretEntity.getName();
        email = secretEntity.getEmail();
        active = secretEntity.getActive();
    }
}
