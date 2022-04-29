package eapli.base.warehouses.dto;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.aisles.Aisles;

import java.util.List;

public class WarehouseDTO {

    public String warehouse;
    public Double warehouseLength;
    public Double warehouseWidth;
    public Double warehouseSquare;
    public String warehouseUnit;
    public List<Aisles> aisles;
    public List<AgvDocks> agvDocks;

    public WarehouseDTO(String warehouse, Double warehouseLength, Double warehouseWidth, Double warehouseSquare,
                        String warehouseUnit, List<Aisles> aisles, List<AgvDocks> agvDocks){
        this.warehouse = warehouse;
        this.warehouseLength = warehouseLength;
        this.warehouseWidth = warehouseWidth;
        this.warehouseSquare = warehouseSquare;
        this.warehouseUnit = warehouseUnit;
        this.aisles = aisles;
        this.agvDocks = agvDocks;
    }

    public WarehouseDTO(){}
}

