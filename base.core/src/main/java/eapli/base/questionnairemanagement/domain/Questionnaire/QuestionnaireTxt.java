package eapli.base.questionnairemanagement.domain.Questionnaire;


import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class QuestionnaireTxt implements AggregateRoot<QuestionnaireID> {

    @EmbeddedId
    private QuestionnaireID id;

    @Embedded
    private FileName fileName;

    @Embedded
    private QuestionnaireState state;

    public QuestionnaireTxt() {

    }

    public QuestionnaireTxt(QuestionnaireID questionnaireID, FileName exemplo, QuestionnaireState questionnaireState) {
        this.id = questionnaireID;
        this.fileName = exemplo;
        this.state = questionnaireState;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(QuestionnaireID other) {
        return AggregateRoot.super.compareTo(other);
    }



    @Override
    public QuestionnaireID identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(QuestionnaireID id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public QuestionnaireID getId() {
        return id;
    }

    public void setId(QuestionnaireID id) {
        this.id = id;
    }

    public FileName getFileName() {
        return fileName;
    }

    public void setFileName(FileName fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "QuestionnaireTxt{" +
                "id=" + id +
                ", fileName=" + fileName +
                ", state=" + state +
                '}';
    }

    public String getState() {
        return state.getState();
    }

    public void setState(QuestionnaireState state) {
        this.state = state;
    }
}
