package mx.ucol.client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SenderM implements Runnable{
    private Socket socket;

    public SenderM (Socket socket) {
        this.socket = socket;
    }

    public void run () {
        DataOutputStream outputStream;
        String msg;
        try {
            do {
                Scanner sc = new Scanner(System.in);
                msg = sc.nextLine();
                outputStream = new DataOutputStream(this.socket.getOutputStream());
                outputStream.writeUTF(msg);
                outputStream.flush();
            } while (!msg.equals("/exit"));
            System.out.println("Uste se a salio");
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("a ocurrido un error: " + e.getMessage());
        }
    }
}