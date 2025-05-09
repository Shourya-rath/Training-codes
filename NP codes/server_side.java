// server socket listen to port 
// socket client accept 
// get Input Stream from client 
// set up buffered reader from InputStreamReader

// ----
// create a socket using the host+ port
// get ouput stream from socket
// Print writer to the output
import java.net.* ;
import java.io.* ;

public class server_side{
    public static void main(String[] args){
        String host = "localhost";
        int port = 5000 ;
try (Socket socket = new Socket(host, port)){
    OutputStream op = socket.getOutputStream() ;
    PrintWriter writer = new PrintWriter(op, true) ;

    
} catch (Exception e) {
}

    }

}