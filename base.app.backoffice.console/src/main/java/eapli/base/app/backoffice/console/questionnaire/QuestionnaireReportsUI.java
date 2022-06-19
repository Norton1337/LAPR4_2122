package eapli.base.app.backoffice.console.questionnaire;

import eapli.base.questionnaire.QuestionnaireMain2;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.framework.io.util.Console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class QuestionnaireReportsUI {

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
        String content = "";
        for (File files : Objects.requireNonNull(folder.listFiles())){
            if(Integer.parseInt(file)==i){
                String answerFile=files.getName().substring(0, files.getName().length() - 4)+"Answers.txt";
                questionnaireController.treatAnswerData(answerFile);
                break;
            }
            i++;

        }


        return true;
    }
}
