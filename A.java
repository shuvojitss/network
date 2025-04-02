import java.util.*;
class A {
    public static String get_Mask(String ip) {
        int firstOctet = Integer.parseInt(ip.split("\\.")[0]);
        if (firstOctet <= 127) return "255.0.0.0";
        if (firstOctet <= 191) return "255.255.0.0";
        if (firstOctet <= 223) return "255.255.255.0";
        return "Invalid IP address";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the IP Address: ");
        String ip = sc.nextLine();
        String mask = get_Mask(ip);
        if ("Invalid IP address".equals(mask)) {
            System.out.println(mask);
            return;
	}
        StringBuilder net_add = new StringBuilder();
        String[] ipParts = ip.split("\\.");
        String[] maskParts = mask.split("\\.");
        for (int i = 0; i < 4; i++)
            net_add.append((Integer.parseInt(ipParts[i]) & Integer.parseInt(maskParts[i])))
                           .append(".");
        System.out.println("Network Address: " + net_add.substring(0, net_add.length() - 1));
    } 
}

