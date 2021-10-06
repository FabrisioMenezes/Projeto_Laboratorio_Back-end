package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name = "ADMINISTRATOR")
public class AdministratorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean active;

    public AdministratorEntity(){

    }

    public AdministratorEntity(String name, String email, String password, Boolean active){

        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public Boolean getActive(){
        return active;
    }

    @Override
    public String toString(){
        return "AdministratorEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", active ='" + active + '\'' +
        '}';
    }
    



}
