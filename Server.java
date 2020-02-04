
import java.io.*;
import java.net.*;


/**
 * Server class acts as a 'server' and creates a socket with the port number 9999. The IP address will be the IP address of the machine.
 * Server then listens continuously over the socket until it receives the data from the client.
 * Server sends the response back to the client and stops.
 * */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Port number to bind server to. Usually above 1023 as 1 - 1023 are well-known ports used by different protocols
        int portNum = 9999;
        
        // Socket for server to listen at.
        ServerSocket listener = new ServerSocket(portNum);

        System.out.println("Server is running at port: " + portNum);
        
        // Making server to listen continuously on the socket for any incoming client request
        while (true) {
            try {
                // Accept a client connection once Server recieves one.
                Socket clientSocket = listener.accept();

                //ObjectOutputStream object to hold a reference to the client socket's output stream
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                

                //ObjectInputStream object to hold a reference to the client socket's input stream         
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                // Reading in Integer Object from input stream.
                int i = (Integer) in.readObject();

                //Sending response back to client
                String response = "Integer Object Received.";
                out.writeObject(response);

                // Outputting recieved Integer Object.
                System.out.println("Received integer: " + i);
                
                //Closing all the streams
                out.close();
                in.close();
                
                //Closing the connection to client socket
                clientSocket.close();
                break;
            } 
            finally 
            {
                      // Closing the server socket (very essential!)
                      listener.close();
               
            }
            
             
                
        }
    }

}
