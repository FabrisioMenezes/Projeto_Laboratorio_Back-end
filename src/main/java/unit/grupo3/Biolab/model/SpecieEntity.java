package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "SPECIE")
public class SpecieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer avaliableQuantity;

    public SpecieEntity(){

    }

    public SpecieEntity(String name, Integer avaliableQuantity){
        this.name = name;
        this.avaliableQuantity = avaliableQuantity;
    }

    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Integer getAvaliableQuantity() {
        return avaliableQuantity;
    }


    @Override
    public String toString() {
        return "SpecieEntity [avaliableQuantity=" + avaliableQuantity + ", id=" + id + ", name=" + name + "]";
    }
    
    
}
