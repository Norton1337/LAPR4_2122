package eapli.base.questionnairemanagement;
import eapli.base.questionnairemanagement.domain.Questionnaire.FileName;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface QuestionnaireRepository extends DomainRepository<FileName, QuestionnaireTxt> {

    public List<QuestionnaireTxt> findAll();
}
