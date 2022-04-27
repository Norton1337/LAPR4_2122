package eapli.base.warehouses.domain.agvDocks;

import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainFactory;


public class AgvDocksBuilder implements DomainFactory<AgvDocks> {

    private AgvDocks theDock;

    private String id;

    private Square begin;

    private Square end;

    private Square depth;

    private Accessibility accessibility;

    public AgvDocksBuilder ofId(final String id){
        this.id=id;
        return this;
    }

    public AgvDocksBuilder ofBegin(final Square begin){
        this.begin=begin;
        return this;
    }
    public AgvDocksBuilder ofEnd(final Square end){
        this.end=end;
        return this;
    }
    public AgvDocksBuilder ofDepth(final Square depth){
        this.depth=depth;
        return this;
    }

    public AgvDocksBuilder accessibleBy(final Accessibility accessibility){
        this.accessibility=accessibility;
        return this;
    }

    private AgvDocks buildOrThrow(){
        if (theDock != null) {
            return theDock;
        } else if (begin != null && end != null && depth != null && accessibility != null) {
            theDock = new AgvDocks(id, begin, end, depth, accessibility);
            return theDock;
        } else {
            throw new IllegalStateException();
        }
    }


    @Override
    public AgvDocks build() {
        final AgvDocks ret = buildOrThrow();
        theDock = null;
        return ret;
    }
}
