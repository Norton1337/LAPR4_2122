package eapli.base.warehouses.domain.warehouse;
import eapli.base.warehouses.domain.aisles.Aisles;

import java.util.List;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;

import javax.persistence.*;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private int id;
    @Embedded
    private WarehouseAddress warehouseAddress;
    @Embedded
    private WarehouseLength warehouseLength;
    @Embedded
    private WarehouseWidth warehouseWidth;
    @Embedded
    private WarehouseSquare warehouseSquare;
    @Embedded
    private WarehouseUnit warehouseUnit;

    @OneToMany
    private List<Aisles> aisles;
    @OneToMany
    private List<AgvDocks> agvDocks;




    public Warehouse(WarehouseAddress warehouseAddress, WarehouseLength warehouseLength, WarehouseWidth warehouseWidth,
                     WarehouseSquare warehouseSquare, WarehouseUnit warehouseUnit, List<Aisles> aisles, List<AgvDocks> agvDocks){

        this.warehouseAddress = warehouseAddress;
        this.warehouseLength = warehouseLength;
        this.warehouseWidth = warehouseWidth;
        this.warehouseSquare = warehouseSquare;
        this.warehouseUnit = warehouseUnit;
        this.aisles = aisles;
        this.agvDocks = agvDocks;
    }

    @Deprecated
    public Warehouse() {
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouseAddress=" + warehouseAddress +
                ", warehouseLength=" + warehouseLength +
                ", warehouseWidth=" + warehouseWidth +
                ", warehouseSquare=" + warehouseSquare +
                ", warehouseUnit=" + warehouseUnit +
                ", aisles=" + aisles +
                ", agvDocks=" + agvDocks +
                '}';
    }

    public static Warehouse valueOf(WarehouseAddress warehouseAddress, WarehouseLength warehouseLength, WarehouseWidth warehouseWidth,
                                    WarehouseSquare warehouseSquare, WarehouseUnit warehouseUnit, List<Aisles> aisles, List<AgvDocks> agvDocks){
        return new Warehouse(warehouseAddress,warehouseLength,warehouseWidth,warehouseSquare,warehouseUnit,aisles,agvDocks);
    }
}
