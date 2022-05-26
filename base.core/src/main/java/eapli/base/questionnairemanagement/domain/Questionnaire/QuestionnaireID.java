package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionnaireID implements ValueObject {

    private String id;

    public QuestionnaireID(String id){
        this.id=id;
    }
    public QuestionnaireID(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QuestionnaireID{" +
                "id='" + id + '\'' +
                '}';
    }
}
