import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * This program demonstrates a simple TCP/IP socket client that reads input
 * from the user and prints echoed message from the server.
 *
 * @author www.codejava.net
 */
public class cliente {



    public static void main(String[] args) {
        byte[] ok;

        String hostname = "192.168.1.7";
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