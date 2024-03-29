package eapli.base.questionnairemanagement.application;


import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.questionnairemanagement.QuestionnaireRepository;
import eapli.base.questionnairemanagement.domain.Questionnaire.FileName;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireID;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireState;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskDateTime;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.taskmanagement.repositories.TaskRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionnaireController {

    private final QuestionnaireRepository questionnaireRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().questionnaire();
    private FileName fileName;
    FileWrite filew = new FileWrite();

        public void createFile(String fileName, String title, String wmsg) throws IOException {
        // enviar para makefile estes dados,criar ficheiro e abrir
            filew.createFile(fileName, title, wmsg);
            QuestionnaireTxt questionnaireTxt = new QuestionnaireTxt();



            List<QuestionnaireTxt> lista = questionnaireRepository.findAll();
            Integer numero = lista.size()+1;

            questionnaireTxt.setFileName(new FileName(fileName));
            questionnaireTxt.setId(new QuestionnaireID(numero.toString()));
            questionnaireTxt.setState(new QuestionnaireState("0"));

            questionnaireRepository.save(questionnaireTxt);
            //QuestionnaireTxt novo =
            //questionnaireRepository.save();

        }

    public void addSection(String text, String fileName, Integer number, String s) throws IOException {
        // enviar para makefile os dados da questao, utilizar ficheiro ja criado com nome fileName
        filew.addSection(text,fileName, number,s);
    }

    public void addQuestion(String text, Integer type, Integer atype, String fileName, Integer number) throws IOException {
        // enviar para makefile os dados da questao, utilizar ficheiro ja criado com nome fileName
        filew.addQuestion(text,type,atype,fileName, number);
    }


    public void addPossibleAnswer(String answer, String fileName) throws IOException {

        // enviar para makefile os dados das respostas, utilizar ficheiro ja criado com nome fileName
        // vai ser adicionado em frente á addQuestion() , ver formataçao de txt com o paulo por causa da grammar
        filew.addPossibleAnswer(answer,fileName);

        }


    public void createFiles(List<QuestionnaireTxt> questionnaires) {
        for (QuestionnaireTxt questionnaireTxt:questionnaires) {
            createFile(questionnaireTxt);
        }
    }

    public void createFile(QuestionnaireTxt questionnaireTxt){

            questionnaireRepository.save(questionnaireTxt);
    }

    public List<QuestionnaireTxt> getAllQuestionnaires(){
        return questionnaireRepository.findAll();
    }

    public List<QuestionnaireTxt> findOpenQuestionnaires() { return questionnaireRepository.findOpenQuestionnaires();}

    public QuestionnaireTxt getQuestionnaireById(String textinho) {
            QuestionnaireID quest = new QuestionnaireID(textinho);
        return questionnaireRepository.getQuestionnaireById(quest);
    }

    public QuestionnaireTxt findQuestionnaireById(String textinho) {
        List<QuestionnaireTxt> list = questionnaireRepository.findAll();
        for (QuestionnaireTxt questionnaireTxt : list) {
            String oi = questionnaireTxt.getId().getId();
                if (oi.equals(textinho)) {
                System.out.println("\n\n Encontrado. \n\n");
                return questionnaireTxt;
            }
        }
        return null;
    }

    public void confirmQuestionnaire(QuestionnaireTxt quest) {
        QuestionnaireState questS = new QuestionnaireState("1");
            quest.setState(questS);
    }

  /*  public List<QuestionnaireTxt> getOpenQuestionnaires() {
        List<QuestionnaireTxt> openL = new ArrayList<>();
        List<QuestionnaireTxt> list = questionnaireRepository.findAll();
        for (QuestionnaireTxt questionnaireTxt : list) {
            if (questionnaireTxt.getState().toString().equals("0"))
                openL.add(questionnaireTxt);
        }
        return openL;

    }
*/

    public void treatAnswerData(String answerFile){
        String content = "";
        try {
            content= Files.readString(Path.of("Questionarios/Answers/" + answerFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String numbersAnswers = content.substring(content.indexOf("\n")+1).trim();
        String[] arrOfNumbersAnswers = numbersAnswers.split("\n");
        List<String> questionNumbers = new ArrayList<>();
        List<String> questionAnswers = new ArrayList<>();

        for (String a : arrOfNumbersAnswers) {
            String[] questionAndAnswers = a.split(",");
            List<String> qAndAList = new ArrayList<>();
            Collections.addAll(qAndAList, questionAndAnswers);
            if(questionNumbers.contains(qAndAList.get(0))){/*
                String oldAnswer = questionAnswers.get(questionNumbers.indexOf(qAndAList.get(0)));
                String newAnswer = qAndAList.get(1);
                System.out.println("old answer="+oldAnswer);
                System.out.println("new answer="+newAnswer);
                String result = " - "+"oldAnswer"+", "+"newAnswer"+" - ";
                System.out.println(result.length());
                System.out.println(result);

                */
                questionAnswers.add(qAndAList.get(1));
            }else {
                questionNumbers.add(qAndAList.get(0));
                questionAnswers.add(qAndAList.get(1));

            }
        }
        int test=0;
        for (int i = 0; i < questionNumbers.size(); i++) {
            System.out.println("\nQuestion["+questionNumbers.get(i)+"]:");
            int pos=0;
            for (String a:questionAnswers) {
                if(i+test*questionNumbers.size()==pos) {
                    System.out.println(a);
                    test++;
                }
                pos++;
            }
            test=0;

        }


    }


}





