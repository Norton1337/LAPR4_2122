package eapli.base.questionnairemanagement.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {


    public static void createFile(String fileName, String title, String wmsg) throws IOException {
        FileWriter f = new FileWriter(fileName);
        try {
            f.write(title);
            f.write(wmsg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void addQuestion(String text, Integer type, Integer atype, String fileName) {
        // Abrir ficheiro ja criado e adiciona texto
    }


    public void addPossibleAnswer(String answer, String fileName) {

    }
}
