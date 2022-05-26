package eapli.base.questionnairemanagement.application;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuestionnaireController {

        public void openFile(String file) throws FileNotFoundException {

            try {
                String line;
                if (file.equals("questionarioTeste.txt")){
                    BufferedReader br = new BufferedReader(new FileReader("lprog/userstory/src/Questionarios/questionarioTeste.txt"));
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                }


            }catch (IOException e){
                e.printStackTrace();
            }

        }




        public void createFile(String fileName, String title, String wmsg)
        {

        }



    }





