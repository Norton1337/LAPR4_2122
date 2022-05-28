package eapli.base.warehouses.domain.aisles;

import org.jetbrains.annotations.NotNull;

public class AisleID implements Comparable<AisleID> {

    private int aisleID;

    public AisleID(int aisleID){
        this.aisleID=aisleID;
    }
    public AisleID(){

    }

    @Override
    public int compareTo(@NotNull AisleID o) {
        return 0;
    }
}
