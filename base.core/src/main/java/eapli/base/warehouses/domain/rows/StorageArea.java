package eapli.base.warehouses.domain.rows;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StorageArea {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Bin bin;

    public StorageArea(){
        this.bin = new Bin();
    }


    @Override
    public String toString() {
        return "StorageArea{" +
                "id=" + id +
                '}';
    }

    public static StorageArea valueOf(){
        return new StorageArea();
    }
}
