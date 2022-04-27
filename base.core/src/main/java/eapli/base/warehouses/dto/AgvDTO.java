package eapli.base.warehouses.dto;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.*;


public class AgvDTO {

    public String identification;
    public Double autonomy;
    public Double maxWeight;
    public String model;
    public String shortDescription;
    public String status;
    public AgvDocks agvDock;

    public AgvDTO(String identification,Double autonomy, Double maxWeight, String model, String shortDescription, String status, AgvDocks agvDock){
        this.identification=identification;
        this.autonomy=autonomy;
        this.maxWeight=maxWeight;
        this.model=model;
        this.shortDescription=shortDescription;
        this.status=status;
        this.agvDock=agvDock;
    }

    public AgvDTO(){}
}
