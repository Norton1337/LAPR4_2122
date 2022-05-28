import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class client extends Thread{



    public void run(){
        byte[] ok;

        String hostname = "192.168.1.7";//server ip
        int port = Integer.parseInt("9991");

        try (Socket socket = new Socket(hostname, port)) {

            DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIn = new DataInputStream(socket.getInputStream());


            /*

            EXEMPLO DE ENVIO DE MENSAGEM PARA O SERVIDOR

            ok=SpomspFormatter.msgFormat(0,"HELLO WORLD".getBytes("UTF-8"));
            sOut.write(ok,0,ok.length);
            System.out.println(ok);
            */

            socket.close();

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}