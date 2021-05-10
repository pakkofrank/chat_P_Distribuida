package mx.ucol.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverM implements Runnable{
    private Socket socket;

    public ReceiverM (Socket socket) {
        this.socket = socket;
    }

    public void run () {
        DataInputStream inputStream;
        String inputData;
        int counter = 0;

        try {
            do {
                counter++;
                inputStream = new DataInputStream(socket.getInputStream());
                inputData = (String) inputStream.readUTF();
                System.out.println("Received message: " + inputData);
            } while (socket.isConnected());

        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
