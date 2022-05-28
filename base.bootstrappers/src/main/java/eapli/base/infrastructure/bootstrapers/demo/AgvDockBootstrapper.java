package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouses.application.AGVController;
import eapli.base.warehouses.application.AGVDockController;
import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvDocks.AgvDocksBuilder;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.Width;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class AgvDockBootstrapper implements Action{

    private final AGVDockController agvDockController = new AGVDockController();

    @Override
    public boolean execute() {

        List<AgvDocks> agvDocks =createAgvDocks();
        agvDockController.configureAGVDock(agvDocks);


        return true;
    }

    private List<AgvDocks> createAgvDocks() {
        List<AgvDocks> agvDocks = new ArrayList<>();

        AgvDocks agvDocks1 = new AgvDocksBuilder()
                .ofId(new AgvDockIdentification("id1"))
                .ofBegin(new Square(new Length(12),new Width(34)))
                .ofEnd(new Square(new Length(12),new Width(34)))
                .ofDepth(new Square(new Length(12),new Width(34)))
                .accessibleBy(new Accessibility("l+"))
                .build();

        AgvDocks agvDocks2 = new AgvDocksBuilder()
                .ofId(new AgvDockIdentification("id2"))
                .ofBegin(new Square(new Length(12),new Width(34)))
                .ofEnd(new Square(new Length(12),new Width(34)))
                .ofDepth(new Square(new Length(12),new Width(34)))
                .accessibleBy(new Accessibility("l+"))
                .build();

        AgvDocks agvDocks3 = new AgvDocksBuilder()
                .ofId(new AgvDockIdentification("id3"))
                .ofBegin(new Square(new Length(12),new Width(34)))
                .ofEnd(new Square(new Length(12),new Width(34)))
                .ofDepth(new Square(new Length(12),new Width(34)))
                .accessibleBy(new Accessibility("l+"))
                .build();

        agvDocks.add(agvDocks1);
        agvDocks.add(agvDocks2);
        agvDocks.add(agvDocks3);

        return agvDocks;
    }
}
