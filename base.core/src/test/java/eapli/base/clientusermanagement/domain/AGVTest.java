package eapli.base.clientusermanagement.domain;

import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.*;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.Width;
import org.junit.Test;

public class AGVTest {


    @Test
    public void createAGVTest(){
        AGV agv = new AGV(
                new AGVIdentification("ID"),
                new Autonomy(5.0),
                new MaxWeight(50.0),
                new Model("model"),
                new ShortDescription("shortDescription"),
                new Status("status"),
                new AgvDocks(
                        new AgvDockIdentification("D2"),
                        new Square(
                                new Length(5),
                                new Width(5)
                                ),
                        new Square(
                                new Length(5),
                                new Width(5)
                                ),
                        new Square(
                                new Length(5),
                                new Width(5)
                                ),
                    new Accessibility("l+")
              )
        );
    }
}
