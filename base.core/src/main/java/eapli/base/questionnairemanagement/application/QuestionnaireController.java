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
                // enviar para makefile estes dados,criar ficheiro e abrir
        }

    public void addQuestion(String text, Integer type, Integer atype, String fileName) {

        // enviar para makefile os dados da questao, utilizar ficheiro ja criado com nome fileName
    }


    public void addPossibleAnswer(String answer, String fileName) {

        // enviar para makefile os dados das respostas, utilizar ficheiro ja criado com nome fileName
        // vai ser adicionado em frente á addQuestion() , ver formataçao de txt com o paulo por causa da grammar

        }



}





