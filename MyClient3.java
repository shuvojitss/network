import java.io.*;
import java.net.*;

public class MyClient3 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());

            dout.writeUTF("GET_DATE_TIME");
            dout.flush();

            String response = din.readUTF();
            System.out.println("Response from server: " + response);

            dout.close();
            din.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


