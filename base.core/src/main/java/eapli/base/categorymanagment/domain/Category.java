package eapli.base.categorymanagment.domain;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private String alphanumericCode;

    @Embedded
    private CategoryDescription description;


    protected Category(){}

    public Category(String alphanumericCode, CategoryDescription description) {
        this.alphanumericCode = alphanumericCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "alphanumericCode='" + alphanumericCode + '\'' +
                ", description=" + description +
                '}';
    }
}
