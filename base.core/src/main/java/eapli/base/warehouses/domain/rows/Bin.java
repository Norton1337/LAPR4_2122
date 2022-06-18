package eapli.base.warehouses.domain.rows;

import eapli.base.productmanagement.domain.product.Product;
import eapli.base.warehouses.domain.square.SquareID;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Bin implements AggregateRoot<BinID> {
    @Id
    @GeneratedValue
    @Column(name = "BINID")
    private int id;

    @Embedded
    private BinID binID;
    @OneToOne(mappedBy = "bin")
    private Product product;

    @OneToOne(mappedBy = "bin")
    private StorageArea storageArea;

    public Bin(){
        this.binID=new BinID(ThreadLocalRandom.current().nextInt(100000000,999999999+1));
    }

    public void setStorageArea(StorageArea storageArea){
        this.storageArea=storageArea;
    }

    public void setProduct(Product product){
        this.product=product;
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

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public BinID identity() {
        return null;
    }
}
