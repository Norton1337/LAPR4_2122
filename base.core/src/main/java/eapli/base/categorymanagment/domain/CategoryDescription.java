package eapli.base.categorymanagment.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;


@Embeddable
public class CategoryDescription implements ValueObject {

    private String description;

    public CategoryDescription() {
    }

    public CategoryDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryDescription{" +
                "description='" + description + '\'' +
                '}';
    }
}
