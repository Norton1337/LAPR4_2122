package eapli.base.questionnairemanagement.application;

import java.io.*;

public class FileWrite {


    public static void createFile(String fileName, String title, String wmsg) throws IOException {
        FileWriter f = new FileWriter(fileName);
        try {
            BufferedWriter buffWrite = new BufferedWriter(f);
            buffWrite.append(title + "\n\n");
            buffWrite.append(wmsg + "\n\n");

            buffWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void addQuestion(String text, Integer type, Integer atype, String fileName) throws IOException {
        // Abrir ficheiro ja criado e adiciona texto

        Writer buffWrite = new FileWriter(fileName, true);
        buffWrite.append("Q. " +text+" ("+type+")["+atype+"]\n");
        buffWrite.close();
    }


    public void addPossibleAnswer(String answer, String fileName) {

    }
}
