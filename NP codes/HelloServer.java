import java.io.*;
import java.net.*;

public class HelloServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            // Accept a single client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Read data from client
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            // Close connection
            clientSocket.close();
            System.out.println("Connection closed. Server shutting down.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
