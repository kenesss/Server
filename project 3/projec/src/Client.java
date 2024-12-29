import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        try {

            Scanner send = new Scanner(System.in);



            Socket socket = new Socket("localhost", 1003);
            System.out.println("Server and client successfully connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());


            while(true){
                System.out.print("Client: ");
                String c = send.nextLine();
                out.print(c + "\n");
                out.flush();
                String s = in.readLine();
                System.out.print("Server: ");
                System.out.print(s + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
