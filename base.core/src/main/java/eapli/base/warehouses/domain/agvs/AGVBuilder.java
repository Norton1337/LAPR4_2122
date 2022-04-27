package eapli.base.warehouses.domain.agvs;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.framework.domain.model.DomainFactory;



public class AGVBuilder implements DomainFactory<AGV> {

    private AGV theAgv;

    private AGVIdentification identification;

    private Autonomy autonomy;

    private MaxWeight maxWeight;

    private Model model;

    private ShortDescription shortDescription;

    private Status status;

    private AgvDocks agvDock;


    public AGVBuilder ofId(final AGVIdentification identification){
        this.identification=identification;
        return this;
    }

    public AGVBuilder ofAutonomy(final Autonomy autonomy){
        this.autonomy=autonomy;
        return this;
    }

    public AGVBuilder ofWeight(final MaxWeight maxWeight){
        this.maxWeight=maxWeight;
        return this;
    }

    public AGVBuilder ofModel(final Model model){
        this.model=model;
        return this;
    }

    public AGVBuilder withShortDescription(final ShortDescription shortDescription){
        this.shortDescription=shortDescription;
        return this;
    }

    public AGVBuilder withStatus(final Status status){
        this.status=status;
        return this;
    }

    public AGVBuilder withAgvDock(final AgvDocks agvDock){
        this.agvDock=agvDock;
        return this;
    }

    private AGV buildOrThrow(){
        if (theAgv != null) {
            return theAgv;
        } else if (identification != null && autonomy != null && maxWeight != null && model != null && shortDescription != null && status != null &&
        agvDock != null) {
            theAgv = new AGV(identification, autonomy,maxWeight,model,shortDescription,status,agvDock);
            return theAgv;
        } else {
            throw new IllegalStateException();
        }
    }


    @Override
    public AGV build() {
        final AGV ret = buildOrThrow();
        theAgv = null;
        return ret;
    }
}
