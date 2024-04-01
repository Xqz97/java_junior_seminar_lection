package lection.lection_5.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address, 1300);

            System.out.println(client.getInetAddress());
            System.out.println(client.getLocalPort());

            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inStream);
            PrintStream printStream = new PrintStream(outStream);

            printStream.println("Привет!");
            System.out.println(dataInputStream.readLine());
            client.close();


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
