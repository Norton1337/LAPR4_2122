import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Written by Martin Ombura Jr. <@martinomburajr>
 */
public class server extends Thread {
    private Socket connectionSocket;

    public server(Socket soc){
        connectionSocket=soc;
    }


    private byte[] ok=new byte[1];


    public void run() {
        try{

            System.out.printf("ligado a ->%s\n",connectionSocket.getRemoteSocketAddress());
            DataOutputStream sOut = new DataOutputStream(connectionSocket.getOutputStream());
            DataInputStream sIn = new DataInputStream(connectionSocket.getInputStream());



            /*

            EXEMPLO DE RECEÇAO DE MENSAGEM

            String msg=SpomspFormatter.readMessage(sIn);
            System.out.println("Message->" + msg);

            */




            boolean done = false;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}