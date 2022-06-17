package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionnaireState implements ValueObject, Comparable<QuestionnaireState> {

    private String state;

    public QuestionnaireState(String state) {
        this.state = state;
    }

    public QuestionnaireState() {

    }


    @Override
    public int compareTo(@NotNull QuestionnaireState o) {
        return 0;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
