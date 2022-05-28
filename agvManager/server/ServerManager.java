import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;




public class ServerManager extends Thread{

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(9991)) {

            System.out.println("Server is listening on port " + 9991);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                new server(socket).start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }


    }



}
