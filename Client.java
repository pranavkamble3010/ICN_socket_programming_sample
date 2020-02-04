
import java.io.*;
import java.net.*;

/**
 * Client class simply makes a connection to the server by creating a socket that connects to the server socket
* Simply write some data and send it over to the server socket and receive the data from the server socket
 * */
public class Client {

    public static void main(String arg[]) throws IOException, ClassNotFoundException {

        int portNum = 9999;

        Socket socket = new Socket("localhost", portNum);

        // Integer Object to send to Server.
        Integer num = new Integer(50);

        //ObjectOutputStream object to hold a reference to the client socket's output stream
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        //ObjectInputStream object to hold a reference to the client socket's input stream
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        out.writeObject(num);
             
        //Read response from the server
        String response = (String) in.readObject();

        System.out.println("Server message: " + response);
        
        //socket.close();
        
    }
}
