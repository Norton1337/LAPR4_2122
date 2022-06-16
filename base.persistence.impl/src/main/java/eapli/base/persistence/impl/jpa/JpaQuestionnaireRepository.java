package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionnairemanagement.QuestionnaireRepository;
import eapli.base.questionnairemanagement.domain.Questionnaire.FileName;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireID;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class JpaQuestionnaireRepository extends JpaAutoTxRepository<QuestionnaireTxt, QuestionnaireID, QuestionnaireID>
        implements QuestionnaireRepository {

    public JpaQuestionnaireRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "QuestionnaireID");
    }

    public JpaQuestionnaireRepository(TransactionalContext tx) {
        super(tx, "QuestionnaireID");
    }

    @Override
    public List<QuestionnaireTxt> findAll(){

        final TypedQuery<QuestionnaireTxt> query = entityManager().createQuery(
                "SELECT p FROM QuestionnaireTxt p",
                QuestionnaireTxt.class
        );
        return query.getResultList();
    }

}
