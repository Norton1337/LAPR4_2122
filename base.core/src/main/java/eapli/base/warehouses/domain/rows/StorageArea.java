package eapli.base.warehouses.domain.rows;

import javax.persistence.*;

@Entity
public class StorageArea {
    @Id
    @GeneratedValue
    @Column(name = "STORAGEAREAID")
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bin_id", referencedColumnName = "BINID")
    private Bin bin;

    @OneToOne(mappedBy = "storageArea")
    private Shelves shelf;

    public StorageArea(){
        this.bin = new Bin();
        this.bin.setStorageArea(this);
    }

    public void setShelf(Shelves shelf){
        this.shelf=shelf;
    }

    @Override
    public String toString() {
        return "StorageArea{" +
                "id=" + id +
                '}';
    }

    public Bin getBin(){
        return this.bin;
    }

    public static StorageArea valueOf(){
        return new StorageArea();
    }
}
