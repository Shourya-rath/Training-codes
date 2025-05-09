import java.net.*;

public class HelloUDPServer {
    public static void main(String[] args) {
        int port = 5000;

        try (DatagramSocket serverSocket = new DatagramSocket(port)){
            
            System.out.println("UDP Server is running on port " + port);

            // Buffer to receive incoming data
            byte[] buffer = new byte[1024];

            // DatagramPacket to receive data
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive data (blocking call)
            serverSocket.receive(packet);

            // Extract message
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received from client: " + received);

            // Close server
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
