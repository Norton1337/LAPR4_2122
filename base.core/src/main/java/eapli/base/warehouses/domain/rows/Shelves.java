package eapli.base.warehouses.domain.rows;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Shelves implements ValueObject {
    @Id
    @GeneratedValue
    @Column(name = "SHELFID")
    private int id;

    private final int shelfIdentification;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_storagearea_id", referencedColumnName = "STORAGEAREAID")
    private StorageArea storageArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROWID")
    private Rows row;

    public Shelves(int shelfId){
        /*Preconditions.ensure(shelfId>0);*/
        this.storageArea=new StorageArea();
        this.shelfIdentification =shelfId;
        this.storageArea.setShelf(this);
    }

    public Shelves() {
        shelfIdentification =0;
    }

    public void setRow(Rows row){
        this.row=row;
    }

    @Override
    public String toString() {
        return "Shelves{" +
                "shelfId=" + shelfIdentification +
                '}';
    }

    public StorageArea getStorageArea(){
        return this.storageArea;
    }

    public static Shelves valueOf(int shelfId){
        return new Shelves(shelfId);
    }


}
