package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {

        int port = 555;

        String[] dialogue = new String[]{"Hi, what is your name?",
                "Are you from Russia (yes/no)?",
                "What city are you from"};

        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        int currentQuestion = 0;

        while (true) {

            final String result = in.readLine();
            System.out.println(result);
            switch (currentQuestion) {
                case 0:
                    out.println(String.format(dialogue[currentQuestion]));
                    break;
                case 1:
//                    out.println(String.format("Hi, %s, %d", result, dialogue[currentQuestion]));
                    out.println("Hi, " + result + " " + dialogue[currentQuestion]);
                    break;
                case 2:
                    if (result.equals("no")) {
                        out.println("What country are you from?");
                        currentQuestion--;
                    } else {
                        out.println(String.format(dialogue[currentQuestion]));
                    }
                    break;
                case 3:
                    out.println(String.format("%s is beautiful city", result));
                    break;
                default:
                    out.println(String.format("Ok"));
            }
            currentQuestion++;

        }
    }
}
