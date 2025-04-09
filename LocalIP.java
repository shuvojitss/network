import java.net.*;
public class LocalIP {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("IP Address: " + InetAddress.getLocalHost().getHostAddress());
    }
}
