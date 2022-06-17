package eapli.base.app.backoffice.console.questionnaire;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.base.questionnairemanagement.domain.Questionnaire.QuestionnaireTxt;
import eapli.framework.actions.Action;
import eapli.framework.io.util.Console;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CreateQuestionnaireUI implements Action {
    private static final String UI_DOUBLE_LINE = "|=====================|===================================================================|";
    private static final String UI_SINGLE_LINE = "|---------------------|-------------------------------------------------------------------|";
    Scanner sc = new Scanner(System.in);

     QuestionnaireController questionnaireController = new QuestionnaireController();

    @Override
    public boolean execute()  {
        int choice, choice1, choice2;
        boolean flag = true;
        while (flag) {
            menuPrint();
            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    String fileName = Console.readNonEmptyLine("Insert QuestionnaireFileName: ","Can't be empty");

                    String title = Console.readNonEmptyLine("Insert Title: ","Can't be empty");

                    String wmsg = Console.readNonEmptyLine("Insert WelcomeMessage: ","Can't be empty");

                    try {
                        questionnaireController.createFile(fileName,title, wmsg);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    boolean flag1 = true;
                    Integer numero1=0;
                    while (flag1) {
                        numero1++;
                        System.out.println(UI_DOUBLE_LINE);
                        System.out.println("1 - Add Section ");
                        System.out.println("2 - Finish Questionnaire ");
                        System.out.println(UI_DOUBLE_LINE);
                        choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1:
                                String text1 = Console.readNonEmptyLine("Section Name: ", "Can't be empty");

                                String text2 = Console.readNonEmptyLine("Section Text: ", "Can't be empty");
                                try {
                                    questionnaireController.addSection(text1, fileName, numero1, text2);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }


                                boolean flag2 = true;
                                Integer numero = 0;
                                while (flag2) {
                                    numero++;
                                    System.out.println(UI_DOUBLE_LINE);
                                    System.out.println("1 - Add Question ");
                                    System.out.println("2 - Finish Questionnaire ");
                                    System.out.println(UI_DOUBLE_LINE);
                                    choice1 = sc.nextInt();

                                    switch (choice1) {
                                        case 1:
                                            String text = Console.readNonEmptyLine("Question Text: ", "Can't be empty");

                                            Integer type = Integer.valueOf(Console.readNonEmptyLine("Insert Question Type ( 1 - Optional     2 - Obligatory )", "Can't be empty"));

                                            Integer atype = Integer.valueOf(Console.readNonEmptyLine("Insert Answer Type ( 1 - MultipleChoice     2 - Numeric     3 - FreeText )", "Can't be empty"));


                                            try {
                                                questionnaireController.addQuestion(text, type, atype, fileName, numero);
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                            if (atype == 1) {
                                                boolean flag3 = true;
                                                while (flag3) {

                                                    System.out.println(UI_SINGLE_LINE);
                                                    System.out.println("1 - Add Answer  ");
                                                    System.out.println("2 - Finish Multiple Choice ");
                                                    System.out.println(UI_SINGLE_LINE);
                                                    choice2 = sc.nextInt();

                                                    switch (choice2) {
                                                        case 1:
                                                            System.out.println("Type Answer ");
                                                            String answer = sc.next();
                                                            try {
                                                                questionnaireController.addPossibleAnswer(answer, fileName);
                                                            } catch (IOException e) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            break;
                                                        case 2:
                                                            flag3 = false;
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:
                                            flag2 = false;
                                            break;
                                    }
                                }


                                break;
                            case 2:
                                flag1 = false;
                                break;
                        }
                    }


                    break;
                //======================================================================================================
                case 2:
                    System.out.println("List with all Questionnaires:");
                    List<QuestionnaireTxt> lista = questionnaireController.getAllQuestionnaires();
                    for (QuestionnaireTxt questionnaireTxt:lista) {
                        String s = String.valueOf(questionnaireTxt.getState());
                        System.out.println("{" + "id=" + questionnaireTxt.getId() + ", fileName=" + questionnaireTxt.getFileName() + ", state=" + s +  '}');
                    }

                    break;
                //======================================================================================================
                case 3:

                    System.out.println("List Opened Questionnaires:");
                    List<QuestionnaireTxt> lista1 = questionnaireController.findOpenQuestionnaires();
                    for (QuestionnaireTxt questionnaireTxt:lista1) {
                        System.out.println("{" + "id=" + questionnaireTxt.getId() + ", fileName=" + questionnaireTxt.getFileName() + ", state= " + questionnaireTxt.getState() +  '}');
                    }

                     /*  System.out.println("\n\n\n");
                    System.out.println("List New Opened Questionnaires:");
                    List<QuestionnaireTxt> lista2 = questionnaireController.getOpenQuestionnaires();
                    for (QuestionnaireTxt questionnaireTxt:lista2) {
                        System.out.println("{" + "id=" + questionnaireTxt.getId() + ", fileName=" + questionnaireTxt.getFileName() + ", state= " + questionnaireTxt.getState() +  '}');
                    }*/

                    System.out.println(UI_SINGLE_LINE);
                    String textinho = Console.readNonEmptyLine("Write ID to Answer or 0 to Exit", "Can't be empty");

                    if (textinho.equals("0"))
                    {} else {
                       // QuestionnaireTxt quest = questionnaireController.getQuestionnaireById(textinho);
                      // System.out.println("{" + "id=" + quest.getId() + ", fileName=" + quest.getFileName() + ", state= " + quest.getState() +  '}');

                       // QuestionnaireTxt quest1 = questionnaireController.findQuestionnaireById(textinho);
                       // System.out.println("{" + "id=" + quest1.getId() + ", fileName=" + quest1.getFileName() + ", state= " + quest1.getState() +  '}');


                        // LER FICHEIRO PARA RESPONDER AS PERGUNTAS.




                    }


                    break;
                //======================================================================================================
                case 4:

                    //Report Questionnaires

                    break;
                //======================================================================================================
                case 5:
                    flag = false;
                    break;
                //======================================================================================================
                default:
                    break;

            }

        }
        return true;
    }


    public void menuPrint() {
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          1          | Create Questionnaire   |");
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          2          | View Questionnaires    |");
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          3          | Open Questionnaires    |");
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          4          | Report Questionnaires    |");
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          5          | Exit                   |");
        System.out.println(UI_SINGLE_LINE);
    }

}
