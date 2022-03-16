package ru.otus.javabootcamp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8092);
            int counter = 1;

            while (counter <= 3) {

                Socket client = server.accept();
                var input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String message = input.readLine();
                System.out.println(message);
                client.close();

                counter++;
            }

            server.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
