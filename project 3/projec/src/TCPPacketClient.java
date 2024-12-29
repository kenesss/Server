import java.net.*;
import java.io.*;

public class TCPPacketClient {
        public static void main(String[] args) throws IOException {
                Socket socket = new Socket("localhost", 1024);
                System.out.println("Connected successfully " );

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader send = new BufferedReader(new InputStreamReader(System.in));
                int serialNo = 1;

                String input;
                while ((input = send.readLine()) != null) {
                        if (input.equals("CLOSE")) {
                                out.println("CLOSE");
                                break;
                        }

                        String data = input;
                        Packet packet = new Packet(serialNo++, data);
                        String packetString = packet.getSerialNo() + "/" + packet.getData();

                        out.println(packetString);

                        String s = in.readLine();
                        String res = in.readLine();
                        System.out.println("Data from server serialNo#" + s+": "+ res);
                        System.out.print("Enter the data packet: ");






                }
                socket.close();
                out.close();
                in.close();
                send.close();
        }









}




