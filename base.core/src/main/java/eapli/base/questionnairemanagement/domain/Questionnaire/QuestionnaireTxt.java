package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class QuestionnaireTxt implements AggregateRoot<FileName> {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    private QuestionnaireID id;

    @Embedded
    private FileName fileName;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(FileName other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public FileName identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(FileName id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
