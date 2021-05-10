package mx.ucol.server;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        int port = 3000;

        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            SenderM sender = new SenderM(socket);
            ReceiverM receiver = new ReceiverM(socket);
            new Thread(sender).start();
            new Thread(receiver).start();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
