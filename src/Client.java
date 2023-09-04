import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        int port = 2002;
        String host = "localhost";
        DataInputStream in;
        DataOutputStream out;
        Socket socket;

        Scanner input = new Scanner(System.in);
        System.out.println("Please input a website");
        String userInput = input.next();

        socket = new Socket(host,port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(userInput);
        String ipAddressString = in.readUTF();
        System.out.println(ipAddressString);
        socket.close();
    }
}