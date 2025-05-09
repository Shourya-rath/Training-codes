import java.net.*;

public class HelloUDPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            

            String message = "Hello, UDP Server!";
            byte[] buffer = message.getBytes();

            InetAddress address = InetAddress.getByName(serverAddress);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

            // Send the packet
            clientSocket.send(packet);

            System.out.println("Message sent to server.");

            // Close client
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
