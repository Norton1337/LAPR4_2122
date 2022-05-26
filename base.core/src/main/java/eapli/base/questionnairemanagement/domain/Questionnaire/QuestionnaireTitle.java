package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionnaireTitle implements ValueObject {

    private String title;

    public QuestionnaireTitle(String title) {
        this.title = title;
    }

    public QuestionnaireTitle() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "QuestionnaireTitle{" +
                "title='" + title + '\'' +
                '}';
    }
}