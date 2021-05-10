package mx.ucol.client;

import java.net.*;

public class App {
    public static void main( String[] args )
    {
        Socket socket;
        int port = 3000;

        try {
            socket = new Socket("localhost", port);
            SenderMessage sender = new SenderMessage(socket);
            ReceiverMessage receiver = new ReceiverMessage(socket);
            new Thread(sender).start();
            new Thread(receiver).start();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
