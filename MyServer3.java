import java.io.*;
import java.net.*;
import java.util.Date;

public class MyServer3 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for client...");
            Socket s = ss.accept(); // establishes connection

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Client says: " + request);

            if ("GET_DATE_TIME".equals(request)) {
                String dateTime = new Date().toString();
                dos.writeUTF("Server date and time: " + dateTime);
            } else {
                dos.writeUTF("Invalid request");
            }

            dis.close();
            dos.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


