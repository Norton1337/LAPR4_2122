package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.OrderState;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.questionnairemanagement.QuestionnaireRepository;
import eapli.base.questionnairemanagement.domain.Questionnaire.FileName;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireID;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireState;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;


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

    @Override
    public List<QuestionnaireTxt> findOpenQuestionnaires() {
        final TypedQuery<QuestionnaireTxt> query = (TypedQuery<QuestionnaireTxt>) entityManager().createQuery(
   "SELECT o FROM QuestionnaireTxt o WHERE o.state = '0' ");
        return query.getResultList();
    }

    @Override
    public QuestionnaireTxt getQuestionnaireById(QuestionnaireID id1) {
        final TypedQuery<QuestionnaireTxt> query = (TypedQuery<QuestionnaireTxt>) entityManager().createQuery(
                "SELECT o FROM QuestionnaireTxt o WHERE o.id = :id ").setParameter("id",id1);

        return (QuestionnaireTxt) query;
    }


    @Override
    public boolean containsOfIdentity(QuestionnaireID id) {
        return QuestionnaireRepository.super.containsOfIdentity(id);
    }

    @Override
    public boolean contains(QuestionnaireTxt entity) {
        return QuestionnaireRepository.super.contains(entity);
    }

    @Override
    public long size() {
        return QuestionnaireRepository.super.size();
    }

    @Override
    public void remove(QuestionnaireTxt entity) {
        QuestionnaireRepository.super.remove(entity);
    }

    @Override
    public void removeOfIdentity(QuestionnaireID entityId) {
        QuestionnaireRepository.super.removeOfIdentity(entityId);
    }


    @Override
    public void forEach(Consumer<? super QuestionnaireTxt> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<QuestionnaireTxt> spliterator() {
        return super.spliterator();
    }
}
