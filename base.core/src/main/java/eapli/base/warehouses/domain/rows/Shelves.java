package eapli.base.warehouses.domain.rows;

import eapli.base.warehouses.domain.square.Accessibility;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Shelves implements ValueObject {
    @Id
    @GeneratedValue
    private int id;

    private final int shelfId;

    @OneToOne
    private StorageArea storageArea;

    public Shelves(int shelfId){
        this.storageArea=new StorageArea();
        this.shelfId=shelfId;
    }

    public Shelves() {
        shelfId=0;
    }

    @Override
    public String toString() {
        return "Shelves{" +
                "shelfId=" + shelfId +
                '}';
    }

    public static Shelves valueOf(int shelfId){
        return new Shelves(shelfId);
    }


}
