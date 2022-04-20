package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 555;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("connect");
            while (!clientSocket.isClosed()) {
                String resp = in.readLine();
                System.out.println(resp);

                String[] respParts = resp.split("\\.");
                String questionNumber = respParts[0];
                switch (questionNumber) {
                    case "1":
                        out.println("computer");
                        break;
                    case "2":
                        out.println("no");
                        break;
                    case "3":
                        out.println("Great Britain");
                        break;
                    case "4":
                        out.println("London");
                        break;
                    default:
                        clientSocket.close();
                        break;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
