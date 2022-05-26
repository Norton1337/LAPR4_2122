package eapli.base.app.backoffice.console.questionnaire;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.base.warehouses.application.WarehouseSetupController;

import java.util.Scanner;

public class CreateQuestionnaireUI {
    private static final String UI_DOUBLE_LINE = "|=====================|===================================================================|";
    private static final String UI_SINGLE_LINE = "|---------------------|-------------------------------------------------------------------|";
    Scanner sc = new Scanner(System.in);


    public void menu() {

        int choice, choice1, choice2;
        boolean flag = true;
        while (flag) {
            menuPrint();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Insert QuestionnaireFileName: ");
                    String fileName = sc.nextLine();

                    System.out.println("Insert Title: ");
                    String title = sc.nextLine();

                    System.out.println("Insert WelcomeMessage: ");
                    String wmsg = sc.nextLine();

                    boolean flag2 = true;
                    while (flag2) {
                        System.out.println(UI_DOUBLE_LINE);
                        System.out.println("1 - Add Question ");
                        System.out.println("2 - Finish Questionnaire ");
                        System.out.println(UI_DOUBLE_LINE);
                        choice1 = sc.nextInt();

                        switch (choice1) {
                            case 1:
                                System.out.println("Question Text");
                                String text = sc.next();

                                System.out.println("Insert Question Type ( 1 - Optional     2 - Obligatory ");
                                Integer type = sc.nextInt();

                                System.out.println("Insert Answer Type ( 1 - MultipleChoice     2 - Numeric     3 - FreeText ");
                                Integer atype = sc.nextInt();

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


                    final QuestionnaireController questionnaireController = new QuestionnaireController();
                    questionnaireController.createFile(fileName,title, wmsg);




                    break;
                //======================================================================================================
                case 2:
                    System.out.println("List with all Questionnaires:");

                    break;
                //======================================================================================================
                case 3:
                    flag = false;
                    break;
                //======================================================================================================
                default:
                    break;

            }

        }
    }

    public void menuPrint() {
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          1          | Create Questionnaire   |");
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          2          | View Questionnaires    |");
        System.out.println(UI_SINGLE_LINE);
        System.out.println("|          3          | Exit                   |");
        System.out.println(UI_SINGLE_LINE);
    }



}
