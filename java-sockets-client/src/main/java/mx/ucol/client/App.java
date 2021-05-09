package mx.ucol.client;

import java.io.*;
import java.net.*;

public class App {
    public static void main( String[] args )
    {
        Socket socket;
        DataOutputStream outputStream;
        int port = 3000;

        try {
            socket = new Socket("localhost", port);
            outputStream = new DataOutputStream(socket.getOutputStream());
            Thread.sleep(3000);
            outputStream.writeUTF("Hola Mundo!");
            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
