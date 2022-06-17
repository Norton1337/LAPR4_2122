package eapli.base.questionnairemanagement;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireID;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface QuestionnaireRepository extends DomainRepository<QuestionnaireID, QuestionnaireTxt> {

    public List<QuestionnaireTxt> findAll();

    public List<QuestionnaireTxt> findOpenQuestionnaires();

    QuestionnaireTxt getQuestionnaireById(QuestionnaireID quest);
}
