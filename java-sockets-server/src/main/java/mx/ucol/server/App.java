package mx.ucol.server;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        int port = 3000;
        DataInputStream inputStream;
        String inputData;

        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Before");
            inputData = (String) inputStream.readUTF();
            System.out.println("After");
            System.out.println("Received message: " + inputData);
            serverSocket.close();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
