package eapli.base.warehouses.domain.rows;

import eapli.base.warehouses.domain.square.Square;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rows {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private Long version;

    @Embedded
    private Square begin;

    @Embedded
    private Square end;

    @OneToMany
    private List<Shelves> shelves;

    public Rows() {
    }

    public Rows(Square begin, Square end, int shelvesAmount){
        Preconditions.nonNull(begin);
        Preconditions.nonNull(end);
        shelves = new ArrayList<>();
        for (int i = 1; i <= shelvesAmount; i++) {
            shelves.add(new Shelves(i));
        }
        this.begin = begin;
        this.end = end;

    }

    @Override
    public String toString() {
        return "Rows{" +
                "id=" + id +
                ", version=" + version +
                ", begin=" + begin +
                ", end=" + end +
                ", shelves=" + shelves +
                '}';
    }

    public static Rows valueOf(Square begin, Square end, int shelvesAmount){
        return new Rows(begin,end,shelvesAmount);
    }
}
