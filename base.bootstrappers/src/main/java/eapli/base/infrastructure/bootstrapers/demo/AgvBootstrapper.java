package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouses.application.AGVController;
import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.Width;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class AgvBootstrapper implements Action{

    private final AGVController agvController = new AGVController();

    @Override
    public boolean execute() {

        List<AgvDTO> agvDTOList =createAGV();
        agvController.configureAGV(agvDTOList);


        return true;
    }

    private List<AgvDTO> createAGV() {
        List<AgvDTO> agvDTOList = new ArrayList<>();
        AgvDTO agvDTO1 = new AgvDTO(
            "identification1",
            45.67,
            300.0,
            "model1",
            "shortDesc1",
            "Status1",
            new AgvDocks(
                    new AgvDockIdentification("id1"),
                    new Square(new Length(23), new Width(23)),
                    new Square(new Length(23), new Width(23)),
                    new Square(new Length(23), new Width(23)),
                    new Accessibility("l+"))
            );

        AgvDTO agvDTO2 = new AgvDTO(
                "identification2",
                45.67,
                300.0,
                "model2",
                "shortDesc2",
                "Status2",
                new AgvDocks(
                        new AgvDockIdentification("id2"),
                        new Square(new Length(23), new Width(23)),
                        new Square(new Length(23), new Width(23)),
                        new Square(new Length(23), new Width(23)),
                        new Accessibility("l+"))
                );

            AgvDTO agvDTO3 = new AgvDTO(
                "identification3",
                45.67,
                300.0,
                "model3",
                "shortDesc3",
                "Status3",
                new AgvDocks(
                        new AgvDockIdentification("id3"),
                        new Square(new Length(23), new Width(23)),
                        new Square(new Length(23), new Width(23)),
                        new Square(new Length(23), new Width(23)),
                        new Accessibility("l+"))
                );


        agvDTOList.add(agvDTO1);
        agvDTOList.add(agvDTO2);
        agvDTOList.add(agvDTO3);


        return agvDTOList;
    }
}
