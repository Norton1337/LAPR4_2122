package eapli.base.questionnairemanagement.domain.Questionnaire;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionnaireWelcomeMessage implements ValueObject {

    private String wmsg;

    public QuestionnaireWelcomeMessage(String wmsg){
        this.wmsg=wmsg;
    }
    public QuestionnaireWelcomeMessage(){}


    public String getWmsg() {
        return wmsg;
    }

    public void setWmsg(String wmsg) {
        this.wmsg = wmsg;
    }

    @Override
    public String toString() {
        return "QuestionnaireWelcomeMessage{" +
                "wmsg='" + wmsg + '\'' +
                '}';
    }
}
