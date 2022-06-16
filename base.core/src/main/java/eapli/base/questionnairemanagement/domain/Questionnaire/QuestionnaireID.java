package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionnaireID implements ValueObject, Comparable<QuestionnaireID> {

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

    @Override
    public int compareTo(@NotNull QuestionnaireID o) {
        return 0;
    }
}
