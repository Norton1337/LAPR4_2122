package eapli.base.clientusermanagement.domain.square;

import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.SquareBuilder;
import eapli.base.warehouses.domain.square.Width;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    private static final Length LENGTH1 = new Length(5);
    private static final Width WIDTH1 = new Width(5);
    private static final Square SQUARE1 = new SquareBuilder().ofLength(LENGTH1).ofWidth(WIDTH1).build();
    private static final Square SQUARE1SAME = new SquareBuilder().ofLength(LENGTH1).ofWidth(WIDTH1).build();
    private static final Length LENGTH2 = new Length(10);
    private static final Width WIDTH2 = new Width(4);
    private static final Square SQUARE2 = new SquareBuilder().ofLength(LENGTH2).ofWidth(WIDTH2).build();

    @Test
    public void testEquals(){
       assertEquals(0,SQUARE1.compareTo(SQUARE1SAME));
    }

    @Test
    public void testDifferent(){
        assertNotEquals(0,SQUARE1.compareTo(SQUARE2));
    }

}
