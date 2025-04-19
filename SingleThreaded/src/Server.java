

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket socket = null;
        try {
           socket = new ServerSocket(port);
            socket.setSoTimeout(100000);
        }catch(IOException e){
            System.out.println("Couldn't find the port");
        }
        while(true){
            System.out.println("Singlethread.Server is listening on port " + port);
            Socket acceptedConnection = socket.accept();
            System.out.println("connection has been secured " + acceptedConnection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("hello from the server");
            toClient.close();
            fromClient.close();
            acceptedConnection.close();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}