package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "AREAOFINTEREST")
public class AreaOfInterestEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public AreaOfInterestEntity(){

    }

    public AreaOfInterestEntity(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return "AreaOfInterestEntity{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + "}";
    }


}
