package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "ANALYSTCOMMISION")
public class AnalystCommissionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long protocolId;
    private String seemDate;
    private String firstAnalyst;
    private String secondAnalyst;
    private String thirdAnalyst;

    public AnalystCommissionEntity(){

    }

    public AnalystCommissionEntity(Long protocolId, String seemDate, String firstAnalyst, String secondAnalyst, String thirdAnalyst){
        this.protocolId = protocolId;
        this.seemDate = seemDate;
        this.firstAnalyst = firstAnalyst;
        this.secondAnalyst = secondAnalyst;
        this.thirdAnalyst = thirdAnalyst;
    }

    public Long getProtocolId(){
        return protocolId;
    }

    public String getSeemDate(){
        return seemDate;
    }

    public String getFirstAnalyst(){
        return firstAnalyst;
    }

    public String getSecondAnalyst(){
        return secondAnalyst;
    }

    public String getThirdAnalyst(){
        return thirdAnalyst;
    }

    @Override
    public String toString(){
        return "AnalystComissionEntity{" +
        "id='" + id + '\'' +
        ", protocolId='" + protocolId + '\''+
        ", seemDate='" + seemDate + '\'' +
        ", firstAnalyst='" + firstAnalyst + '\'' +
        ", secondAnalyst='" + secondAnalyst + '\'' +
        ", thirdAnalyst='" + thirdAnalyst + '\'' +
        "}";
    }



}
