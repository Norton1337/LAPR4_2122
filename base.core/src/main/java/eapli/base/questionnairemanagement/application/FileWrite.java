package eapli.base.questionnairemanagement.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {


    public void createFile(String fileName, String title, String wmsg) throws IOException {
        FileWriter f = new FileWriter(fileName);
        try {
            f.write(title);
            f.write(wmsg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
