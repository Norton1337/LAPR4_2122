package eapli.base.warehouses.domain.warehouse;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.framework.domain.model.DomainFactory;


import java.io.IOException;
import java.util.List;


public class WarehouseBuilder implements DomainFactory<Warehouse> {

    private Warehouse theWarehouse;

    private WarehouseIdentification warehouseIdentification;

    private WarehouseLength warehouseLength;

    private WarehouseWidth warehouseWidth;

    private WarehouseSquare warehouseSquare;

    private WarehouseUnit warehouseUnit;

    private List<Aisles> aisles;

    private List<AgvDocks> agvDocks;


    public WarehouseBuilder ofAddress(final WarehouseIdentification warehouseIdentification){
        this.warehouseIdentification = warehouseIdentification;
        return this;
    }
    public WarehouseBuilder ofLength(final WarehouseLength warehouseLength){
        this.warehouseLength=warehouseLength;
        return this;
    }
    public WarehouseBuilder ofWidth(final WarehouseWidth warehouseWidth){
        this.warehouseWidth=warehouseWidth;
        return this;
    }

    public WarehouseBuilder withSquare(final WarehouseSquare warehouseSquare){
        this.warehouseSquare=warehouseSquare;
        return this;
    }

    public WarehouseBuilder ofUnit(final WarehouseUnit warehouseUnit){
        this.warehouseUnit=warehouseUnit;
        return this;
    }

    public WarehouseBuilder withAisles(final List<Aisles> aisles){
        this.aisles=aisles;
        return this;
    }

    public WarehouseBuilder withAgvDocks(final List<AgvDocks> agvDocks){
        this.agvDocks=agvDocks;
        return this;
    }

    private Warehouse buildOrThrow() throws IOException {
        if (theWarehouse != null) {
            return theWarehouse;
        } else if (warehouseIdentification != null && warehouseLength != null && warehouseSquare != null && warehouseUnit != null
                && warehouseWidth != null && !aisles.isEmpty() && !agvDocks.isEmpty()) {
            theWarehouse = new Warehouse(warehouseIdentification,warehouseLength,warehouseWidth,warehouseSquare,warehouseUnit,aisles,agvDocks);
            return theWarehouse;
        } else {
            throw new IllegalStateException();
        }
    }


    @Override
    public Warehouse build() {
        final Warehouse ret;
        try {
            ret = buildOrThrow();
            theWarehouse = null;
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
