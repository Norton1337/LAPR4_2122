package eapli.base.warehouses.domain.square;

import eapli.framework.domain.model.DomainFactory;

public class SquareBuilder implements DomainFactory<Square> {

    private Square theSquare;

    private Width width;

    private Length length;


    public SquareBuilder ofWidth(final Width width){
        this.width=width;
        return this;
    }

    public SquareBuilder ofLength(final Length length){
        this.length=length;
        return this;
    }


    private Square buildOrThrow(){
        if (theSquare != null) {
            return theSquare;
        } else if (width != null && length != null) {
            theSquare = new Square(length,width);
            return theSquare;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Square build() {
        final Square ret = buildOrThrow();
        theSquare = null;
        return ret;
    }
}
