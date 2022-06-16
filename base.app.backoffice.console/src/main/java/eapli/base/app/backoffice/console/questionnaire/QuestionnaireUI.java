package eapli.base.app.backoffice.console.questionnaire;

import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.framework.io.util.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class QuestionnaireUI {

    private QuestionnaireController questionnaireController = new QuestionnaireController();

    public boolean show() throws FileNotFoundException {

        String file;
        System.out.println("Questionários");

        try {
            File folder = new File("src/com/company/Questionario");

            if (folder.isDirectory()){

                for (File files : Objects.requireNonNull(folder.listFiles())){

                    //String fileName = folder.getName();
                    System.out.println(files.getName());

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        file = Console.readNonEmptyLine("Escolha um questionário", "Obrigatória a escolha de uma opção");
        //questionnaireController.openFile(file);

        return true;
    }
}
