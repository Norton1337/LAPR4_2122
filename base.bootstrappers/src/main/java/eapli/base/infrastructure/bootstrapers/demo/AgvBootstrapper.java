package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouses.application.AGVController;
import eapli.base.warehouses.application.AGVDockController;
import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvDocks.AgvDocksBuilder;
import eapli.base.warehouses.domain.agvs.*;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.Width;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class AgvBootstrapper implements Action {

    private final AGVController agvController = new AGVController();

    @Override
    public boolean execute() {


        List<AGV> agvList = createAGV();
        agvController.configureAGV(agvList);
        return true;
    }

    private List<AGV> createAGV() {
        List<AGV> agvList = new ArrayList<>();

        AGVDockController agvDockController = new AGVDockController();
        List<AgvDocks> agvDocksList = createAgvDocks();

        AGV agv = new AGV(
                new AGVIdentification("identification1"),
                new Autonomy(45.67),
                new MaxWeight(300.0),
                new Model("model1"),
                new ShortDescription("shortDesc1"),
                new Status("status1"),
                agvDocksList.get(0));


        AGV agv1 = new AGVBuilder()
                .ofId(new AGVIdentification("identification1"))
                .ofAutonomy(new Autonomy(45.67))
                .ofWeight(new MaxWeight(300.0))
                .ofModel(new Model("model1"))
                .withShortDescription(new ShortDescription("shortDesc1"))
                .withStatus(new Status("Status1"))
                .withAgvDock(agvDocksList.get(0))
                .build();

        agvDocksList.get(0).setAgv(agv1);
        AGV agv2 = new AGVBuilder()
                .ofId(new AGVIdentification("identification2"))
                .ofAutonomy(new Autonomy(45.67))
                .ofWeight(new MaxWeight(300.0))
                .ofModel(new Model("model2"))
                .withShortDescription(new ShortDescription("shortDesc2"))
                .withStatus(new Status("Status2"))
                .withAgvDock(agvDocksList.get(1))
                .build();
        agvDocksList.get(1).setAgv(agv2);
        AGV agv3 = new AGVBuilder()
                .ofId(new AGVIdentification("identification3"))
                .ofAutonomy(new Autonomy(45.67))
                .ofWeight(new MaxWeight(300.0))
                .ofModel(new Model("model3"))
                .withShortDescription(new ShortDescription("shortDesc3"))
                .withStatus(new Status("Status3"))
                .withAgvDock(agvDocksList.get(2))
                .build();
        agvDocksList.get(2).setAgv(agv3);
        agvList.add(agv1);
        agvList.add(agv2);
        agvList.add(agv3);



        return agvList;
    }

    private List<AgvDocks> createAgvDocks() {
        List<AgvDocks> agvDocks = new ArrayList<>();

        AgvDocks agvDocks1 = new AgvDocksBuilder()
                .ofId(new AgvDockIdentification("id1"))
                .ofBegin(new Square(new Length(12), new Width(34)))
                .ofEnd(new Square(new Length(12), new Width(34)))
                .ofDepth(new Square(new Length(12), new Width(34)))
                .accessibleBy(new Accessibility("l+"))
                .build();

        AgvDocks agvDocks2 = new AgvDocksBuilder()
                .ofId(new AgvDockIdentification("id2"))
                .ofBegin(new Square(new Length(12), new Width(34)))
                .ofEnd(new Square(new Length(12), new Width(34)))
                .ofDepth(new Square(new Length(12), new Width(34)))
                .accessibleBy(new Accessibility("l+"))
                .build();

        AgvDocks agvDocks3 = new AgvDocksBuilder()
                .ofId(new AgvDockIdentification("id3"))
                .ofBegin(new Square(new Length(12), new Width(34)))
                .ofEnd(new Square(new Length(12), new Width(34)))
                .ofDepth(new Square(new Length(12), new Width(34)))
                .accessibleBy(new Accessibility("l+"))
                .build();

        agvDocks.add(agvDocks1);
        agvDocks.add(agvDocks2);
        agvDocks.add(agvDocks3);

        return agvDocks;
    }
}
