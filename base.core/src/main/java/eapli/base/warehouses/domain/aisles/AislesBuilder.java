package eapli.base.warehouses.domain.aisles;


import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainFactory;

import java.util.List;


public class AislesBuilder implements DomainFactory<Aisles> {

    private Aisles theAisle;

    private int aisleID;

    private Square begin;

    private Square end;

    private Square depth;

    private Accessibility accessibility;

    private List<Rows> rowsList;

    public AislesBuilder ofID(final int aisleID){
        this.aisleID=aisleID;
        return this;
    }

    public AislesBuilder ofBegin(final Square begin){
        this.begin=begin;
        return this;
    }
    public AislesBuilder ofEnd(final Square end){
        this.end=end;
        return this;
    }
    public AislesBuilder ofDepth(final Square depth){
        this.depth=depth;
        return this;
    }

    public AislesBuilder accessibleBy(final Accessibility accessibility){
        this.accessibility=accessibility;
        return this;
    }

    public AislesBuilder withRows(final List<Rows> rowsList){
        this.rowsList=rowsList;
        return this;
    }

    private Aisles buildOrThrow(){
        if (theAisle != null) {
            return theAisle;
        } else if (aisleID!=0 && begin != null && end != null && depth != null && accessibility != null && !rowsList.isEmpty()) {
            theAisle = new Aisles(aisleID,begin, end, depth, accessibility, rowsList);
            return theAisle;
        } else {
            throw new IllegalStateException();
        }
    }


    @Override
    public Aisles build() {
        final Aisles ret = buildOrThrow();
        theAisle = null;
        return ret;
    }
}
