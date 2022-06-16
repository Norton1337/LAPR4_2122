package eapli.base.infrastructure.bootstrapers.demo;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.base.questionnairemanagement.domain.Questionnaire.FileName;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireID;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireBootstrapper implements Action {

    private final QuestionnaireController questionnaireController = new QuestionnaireController();


    @Override
    public boolean execute() {
        List<QuestionnaireTxt> questionnaires = createQuestionnaires();

        questionnaireController.createFiles(questionnaires);

        return true;
    }

    private List<QuestionnaireTxt> createQuestionnaires() {
        List<QuestionnaireTxt> questionnaireList = new ArrayList<>();

        QuestionnaireTxt q1 = new QuestionnaireTxt(new QuestionnaireID("1"), new FileName("exemplo1"));
        QuestionnaireTxt q2 = new QuestionnaireTxt(new QuestionnaireID("2"), new FileName("exemplo2"));
        QuestionnaireTxt q3 = new QuestionnaireTxt(new QuestionnaireID("3"), new FileName("exemplo3"));

        questionnaireList.add(q1);
        questionnaireList.add(q2);
        questionnaireList.add(q3);

        return questionnaireList;
    }
}
