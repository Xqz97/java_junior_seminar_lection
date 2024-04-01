package seminar5.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientManager implements Runnable {
    private final Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String name;
    public final static ArrayList<ClientManager> clients = new ArrayList<>();


    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeAll(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        for (ClientManager client : clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeAll(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Удаление клиента из коллекции
        removeClient();
        try {
            // Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
            // Завершаем работу буфера на чтение данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeClient() {
        clients.remove(this);
        System.out.printf(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул к чату.");
    }
}

