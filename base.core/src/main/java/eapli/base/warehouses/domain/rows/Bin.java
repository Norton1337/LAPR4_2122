package eapli.base.warehouses.domain.rows;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bin {
    @Id
    @GeneratedValue
    private int id;

    public Bin(){
    }


    @Override
    public String toString() {
        return "Bin{" +
                "id=" + id +
                '}';
    }

    public static Bin valueOf(){
        return new Bin();
    }
}
