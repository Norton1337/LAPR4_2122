package eapli.base.warehouses.domain.aisles;

import eapli.base.warehouses.domain.rows.Shelves;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;

import java.util.List;

import eapli.base.warehouses.domain.rows.Rows;

import javax.persistence.*;

@Entity
public class Aisles {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private Long version;

    @Embedded
    private Square begin;

    @Embedded
    private Square end;

    @Embedded
    private Square depth;

    @Embedded
    private Accessibility accessibility;

    @OneToMany
    private List<Rows> rows;

    protected Aisles() {
    }

    public Aisles (Square begin, Square end, Square depth, Accessibility accessibility, List<Rows> rows){
        this.begin=begin;
        this.end=end;
        this.depth=depth;
        this.accessibility=accessibility;
        this.rows=rows;
    }

    @Override
    public String toString() {
        return "Aisles{" +
                "id=" + id +
                ", version=" + version +
                ", being=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                ", rows=" + rows +
                '}';
    }

    public static Aisles valueOf(Square begin, Square end, Square depth, Accessibility accessibility, List<Rows> rows){
        return new Aisles(begin,end,depth,accessibility,rows);
    }
}
