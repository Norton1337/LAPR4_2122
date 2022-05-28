package eapli.base.warehouses.domain.agvDocks;

import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainFactory;


public class AgvDocksBuilder implements DomainFactory<AgvDocks> {

    private AgvDocks theDock;

    private AgvDockIdentification agvDockIdentification;

    private Square begin;

    private Square end;

    private Square depth;

    private Accessibility accessibility;

    private AGV agv;

    public AgvDocksBuilder ofId(final AgvDockIdentification agvDockIdentification){
        this.agvDockIdentification=agvDockIdentification;
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
    public AgvDocksBuilder withAGV(final AGV agv){
        this.agv=agv;
        return this;
    }

    private AgvDocks buildOrThrow(){
        if (theDock != null) {
            return theDock;
        } else if (agvDockIdentification != null && begin != null && end != null && depth != null && accessibility != null) {
            theDock = new AgvDocks(agvDockIdentification, begin, end, depth, accessibility);
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
