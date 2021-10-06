package unit.grupo3.Biolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "ANALYSTCOMMISION")
public class AnalystCommissionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long protocolId;
    private Date seemDate;
    private Long firstAnalystId;
    private Long secondAnalystId;
    private Long thirdAnalystId;

    public AnalystCommissionEntity(){

    }

    public AnalystCommissionEntity(Long protocolId, Date seemDate, Long firstAnalystId, Long secondAnalystId, Long thirdAnalystId){
        this.protocolId = protocolId;
        this.seemDate = seemDate;
        this.firstAnalystId = firstAnalystId;
        this.secondAnalystId = secondAnalystId;
        this.thirdAnalystId = thirdAnalystId;
    }

    public Long getProtocolId(){
        return protocolId;
    }

    public Date getSeemDate(){
        return seemDate;
    }

    public Long getFirstAnalystId(){
        return firstAnalystId;
    }

    public Long getSecondAnalystId(){
        return secondAnalystId;
    }

    public Long getThirdAnalystId(){
        return thirdAnalystId;
    }

    @Override
    public String toString(){
        return "AnalystComissionEntity{" +
        "id='" + id + '\'' +
        ", protocolId='" + protocolId + '\''+
        ", seemDate='" + seemDate + '\'' +
        ", firstAnalyst='" + firstAnalystId + '\'' +
        ", secondAnalyst='" + secondAnalystId + '\'' +
        ", thirdAnalyst='" + thirdAnalystId + '\'' +
        "}";
    }



}
