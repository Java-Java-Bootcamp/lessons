package ru.otus.javabootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket  = new Socket("127.0.0.1", 8092);
            String message = "Hello server";
            var output = new PrintWriter(socket.getOutputStream(), true);
            output.println(message);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
