package eapli.base.warehouses.domain.rows;

import javax.persistence.*;

@Entity
public class Bin {
    @Id
    @GeneratedValue
    @Column(name = "BINID")
    private int id;

    @OneToOne(mappedBy = "bin")
    private StorageArea storageArea;

    public Bin(){
    }

    public void setStorageArea(StorageArea storageArea){
        this.storageArea=storageArea;
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
