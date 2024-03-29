package eapli.base.app.backoffice.console.questionnaire;

import eapli.base.questionnaire.QuestionnaireMain2;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.framework.io.util.Console;


import java.io.File;
import java.util.Objects;

public class QuestionnaireUI {

    private QuestionnaireController questionnaireController = new QuestionnaireController();

    public boolean show() {

        String file;
        File folder = new File("Questionarios/QuestionariosUS3501");
        try {


            if (folder.isDirectory()){
                System.out.println("Questionários:\n");
                int i=0;
                for (File files : Objects.requireNonNull(folder.listFiles())){

                    //String fileName = folder.getName();
                    System.out.println("["+i+"] "+files.getName());
                    i++;

                }
                if(i==0){
                    System.out.println("There are no Questionnaires available");
                    return false;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        file = Console.readNonEmptyLine("Escolha um questionário", "Obrigatória a escolha de uma opção");
        int i=0;
        for (File files : Objects.requireNonNull(folder.listFiles())){
            if(Integer.parseInt(file)==i){

                QuestionnaireMain2.answerQuestionnaire(String.valueOf(files));
            }
            i++;

        }
        System.out.println(file);

        return true;
    }
}
