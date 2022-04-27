package eapli.base.warehouses.domain.rows;


import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainFactory;


public class RowsBuilder implements DomainFactory<Rows> {

    private Rows theRow;

    private int rowID;

    private Square begin;

    private Square end;

    private int shelvesAmount;


    public RowsBuilder ofID(final int rowID){
        this.rowID=rowID;
        return this;
    }
    public RowsBuilder ofBegin(final Square begin){
        this.begin=begin;
        return this;
    }
    public RowsBuilder ofEnd(final Square end){
        this.end=end;
        return this;
    }

    public RowsBuilder withShelvesAmount(final int shelvesAmount){
        this.shelvesAmount=shelvesAmount;
        return this;
    }

    private Rows buildOrThrow(){
        if (theRow != null) {
            return theRow;
        } else if (rowID!=0 && begin != null && end != null && shelvesAmount!=0) {
            theRow = new Rows(rowID, begin, end, shelvesAmount);
            return theRow;
        } else {
            throw new IllegalStateException();
        }
    }


    @Override
    public Rows build() {
        final Rows ret = buildOrThrow();
        theRow = null;
        return ret;
    }
}
