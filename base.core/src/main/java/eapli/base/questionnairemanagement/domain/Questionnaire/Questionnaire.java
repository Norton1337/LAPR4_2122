package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.base.customermanagement.domain.*;

import javax.persistence.*;

@Entity
public class Questionnaire {

    @GeneratedValue
    @EmbeddedId
    private QuestionnaireID id;

    @Embedded
    private QuestionnaireTitle title;

    @Embedded
    private QuestionnaireWelcomeMessage wmsg;

    protected Questionnaire() {
        // for ORM
    }

    public Questionnaire(QuestionnaireID id, QuestionnaireTitle title, QuestionnaireWelcomeMessage wmsg) {
        this.id = id;
        this.title = title;
        this.wmsg = wmsg;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", title=" + title +
                ", wmsg=" + wmsg +
                '}';
    }
}
