import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    public Consumer<Socket> getConsumer() throws IOException{
        return (clientsocket)->{

        };
    }
    public void run() throws IOException {
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(20000);
        System.out.println("multithreaded server is listening on port "+ port);
        while(true){
            Socket acceptedConnection = socket.accept();
            Thread thread = new Thread();


        }
    }
    public static void main(String[] args) {

    }
}