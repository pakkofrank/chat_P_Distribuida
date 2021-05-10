package mx.ucol.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiverM implements Runnable{
    private Socket socket;

    public ReceiverM(Socket socket) {
        this.socket = socket;
    }

    public void run () {
        DataInputStream inputStream;
        String inputData;

        try {
            do {
                inputStream = new DataInputStream(this.socket.getInputStream());
                inputData = (String) inputStream.readUTF();
                System.out.println("Received message: " + inputData);
            } while (socket.isConnected());
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}