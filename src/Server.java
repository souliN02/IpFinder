import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        int port = 2002;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;

        server = new ServerSocket(port);
        socket = server.accept();
        System.out.println("Waiting for input");
        in = new DataInputStream( socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        String url = in.readUTF();
        InetAddress internetAddress = InetAddress.getByName(url);
        String ip = internetAddress.getHostAddress();
        out.writeUTF(ip);
        socket.close();
    }
}