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

                if (resp.contains("what is your name")) {
                    out.println("computer");
                } else if (resp.contains("Are you from Russia")) {
                    out.println("no");
                } else if (resp.contains("What country are you from")) {
                    out.println("Great Britain");
                } else if (resp.contains("What city are you from")) {
                    out.println("London");
                } else {
                    clientSocket.close();
                    break;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
