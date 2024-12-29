import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1003);
            Socket socket = serverSocket.accept();
            System.out.println("Server and client successfully connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner send = new Scanner(System.in);

            while (true) {

                System.out.print("Client: " + in.readLine() + "\n");
                System.out.print("Server: ");
                String s = send.nextLine();
                out.print(s + "\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

