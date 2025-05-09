import java.io.*;
import java.net.*;

public class HelloClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Send a message
            writer.println("Hello, Server!");
            writer.println("This is the client speaking.");
            writer.println(); // To signal end of input

            System.out.println("Message sent to server.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
