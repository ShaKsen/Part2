package ru.geekbrains.shavshina2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new EchoServer().startServer();
    }

    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startServer() {
        try {
            clientServer() ;

            Scanner scanner = new Scanner(System.in);
            while (true) {
                sendMessage(scanner.nextLine());
            }
        }
         catch(IOException e){
                e.printStackTrace();
            }
        }

        private void clientServer()throws IOException{
            try (ServerSocket serverSocket = new ServerSocket(8189)) {
                System.out.println("Ждём подключения клиента");
                final Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                new Thread(() -> {
                    try {
                        while (true) {
                            final String message = in.readUTF();
                            if ("/end".equalsIgnoreCase(message)) {
                                break;
                            }
                            System.out.println("Сообщение от клиента: " + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();
            }   catch (IOException e) {
                e.printStackTrace();
            }

        }
        }


