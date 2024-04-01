package seminar5.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Введите свое имя: ");
            //Укажем свое имя
            String name = myScanner.nextLine();


            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
