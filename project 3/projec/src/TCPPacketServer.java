import java.net.*;
import java.io.*;

public class TCPPacketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);
        System.out.println("Server started on port 1024...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected successfully");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("CLOSE")) {
                    out.println("Connection closed by client");
                    break;
                }


                String[] parts = inputLine.split("/");
                int serialNo = Integer.parseInt(parts[0]);
                String data = parts[1];


                out.println(serialNo);
                String response = data.toUpperCase();
                out.println(response);
                System.out.println("The data serialNo#"+ serialNo+" you sent: " + response);
            }

            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Client disconnected");
        }
    }





