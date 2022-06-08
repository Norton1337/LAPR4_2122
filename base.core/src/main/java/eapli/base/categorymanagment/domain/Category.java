package eapli.base.categorymanagment.domain;

import eapli.base.productmanagement.domain.product.Product;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Category implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORYID")
    private Long id;

    private String alphanumericCode;

    @Embedded
    private CategoryDescription description;

    @OneToOne(mappedBy = "productCategory")
    private Product product;

    protected Category(){}

    public Category(String alphanumericCode, CategoryDescription description) {
        this.alphanumericCode=alphanumericCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "alphanumericCode='" + alphanumericCode + '\'' +
                ", description=" + description +
                '}';
    }

    public String alphanumericCode(){
        return this.alphanumericCode;
    }
    public CategoryDescription categoryDescription(){
        return this.categoryDescription();
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }
}
