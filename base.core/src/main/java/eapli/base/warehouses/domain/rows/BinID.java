package eapli.base.warehouses.domain.rows;


public class BinID implements Comparable<BinID> {

    private int binIdentificaiton;

    public BinID(int binIdentificaiton){
        this.binIdentificaiton =binIdentificaiton;
    }
    public BinID(){

    }

    public int getBinID(){
        return binIdentificaiton;
    }

    @Override
    public int compareTo(BinID o) {
        return 0;
    }
}
