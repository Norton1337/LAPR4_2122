package eapli.base.clientusermanagement.domain.agvDocks;

import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.SquareBuilder;
import eapli.base.warehouses.domain.square.Width;
import org.junit.Test;

public class agvDocksTest {
    private static final Length length1 = new Length(5);
    private static final Length length2 = new Length(5);
    private static final Length length3 = new Length(5);
    private static final Width width1 = new Width(5);
    private static final Width width2 = new Width(5);
    private static final Width width3 = new Width(5);
    private static final Square BEGIN_SQUARE = new SquareBuilder().ofLength(length1).ofWidth(width1).build();
    private static final Square END_SQUARE = new SquareBuilder().ofLength(length2).ofWidth(width2).build();
    private static final Square DEPTH_SQUARE = new SquareBuilder().ofLength(length3).ofWidth(width3).build();



    @Test
    public void test(){

    }
}
