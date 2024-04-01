package seminar5.chat.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket; // Объявление переменной socket - сокет для соединения
    private final String name; // Объявление переменной name - имя пользователя
    private BufferedWriter bufferedWriter; // Поток для записи данных в сокет
    private BufferedReader bufferedReader; // Поток для чтения данных из сокета

    public Client(Socket socket, String userName) { // Конструктор класса, принимает сокет и имя пользователя
        this.socket = socket; // Инициализация переменной socket переданной извне
        name = userName; // Инициализация переменной name переданной извне
        try {
            // Инициализация потока для записи данных в сокет
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // Инициализация потока для чтения данных из сокета
            bufferedReader = new BufferedReader((new InputStreamReader(socket.getInputStream())));
        } catch (IOException e) { // Обработка исключения в случае ошибки ввода-вывода
            // Обработка ошибки
        }
    }

    /**
     * Слушатель для входных сообщений
     */
    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
               String message;
               while (socket.isConnected()){
                   try {
                       message = bufferedReader.readLine();
                       System.out.println(message);
                   } catch (IOException e) {
                       closeEverything(socket, bufferedReader, bufferedWriter );
                   }

               }
            }
        }).start();
    }
    /**
     * Отправить сообщение
     */
    public void sendMessage() throws IOException {
        bufferedWriter.write(name);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        Scanner scanner = new Scanner(System.in);
        while (socket.isConnected()){
            String message = scanner.nextLine();
            bufferedWriter.write(name + ": "+ message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }
    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter ) {
        // Метод для закрытия всех ресурсов (сокет, потоки ввода-вывода)
        try {
            if (bufferedReader != null) {
                bufferedReader.close(); // Закрытие потока чтения данных
            }
            if (bufferedWriter != null) {
                bufferedWriter.close(); // Закрытие потока записи данных
            }

            if (socket != null) {
                socket.close(); // Закрытие сокета
            }
        } catch (IOException e) { // Обработка исключения в случае ошибки ввода-вывода
            e.printStackTrace(); // Вывод стека вызовов исключения
        }
    }
}