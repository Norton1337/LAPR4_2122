package eapli.base.questionnairemanagement.application;

import java.io.*;

public class FileWrite {


    public static void createFile(String fileName, String title, String wmsg) throws IOException {
        FileWriter f = new FileWriter(fileName);
        try {
            BufferedWriter buffWrite = new BufferedWriter(f);
            buffWrite.append(title + "\n\n");
            buffWrite.append(wmsg + "\n");

            buffWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   // Section2: Other (this section is about other stuff)
    public void addSection(String text, String fileName, Integer number, String s) throws IOException {
        // Abrir ficheiro ja criado e adiciona texto
        Writer buffWrite = new FileWriter(fileName, true);
        buffWrite.append("\n");
        buffWrite.append("\n Section"+number+": " +text+" ("+s+")");
        buffWrite.close();
    }


    public void addQuestion(String text, Integer type, Integer atype, String fileName, Integer number) throws IOException {
        // Abrir ficheiro ja criado e adiciona texto
        String s="";
        String s1="";
        Writer buffWrite = new FileWriter(fileName, true);
            if(type==1)
                s = "optional";
            if(type==2)
                s = "obligatory";
            if(atype==1)
                s1 = "Multiple Choice";
                if(atype==2)
                    s1 ="Numeric";
                    if (atype==3)
                        s1 ="Free Text";
        buffWrite.append("\n");
        buffWrite.append("\n");
        buffWrite.append("\nQ"+number+". " +text+" ("+s+")["+s1+"]");
        buffWrite.close();
    }


    public void addPossibleAnswer(String answer, String fileName) throws IOException {
        Writer buffWrite = new FileWriter(fileName, true);
        buffWrite.append(" "+answer+" |");
        buffWrite.close();
    }
}
