package eapli.base.warehouses.domain.square;



public class SquareID implements Comparable<SquareID> {

    private int squareIdentification;

    public SquareID(int squareIdentification){
        this.squareIdentification =squareIdentification;
    }
    public SquareID(){

    }

    @Override
    public int compareTo(SquareID o) {
        return 0;
    }
}
