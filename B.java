import java.util.*;

class B {
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
        System.out.print("Enter the number of subnets: ");
        int n = sc.nextInt();
        
        String mask = get_Mask(ip);
        if ("Invalid IP address".equals(mask)) {
            System.out.println(mask);
            return;
        }
        
        System.out.println("Default Subnet Mask: " + mask);
        
        StringBuilder net_add = new StringBuilder();
        String[] ipParts = ip.split("\\.");
        String[] maskParts = mask.split("\\.");
        
        for (int i = 0; i < 4; i++) {
            net_add.append((Integer.parseInt(ipParts[i]) & Integer.parseInt(maskParts[i]))).append(".");
        }
        String networkAddress = net_add.substring(0, net_add.length() - 1);
        System.out.println("Network Address: " + networkAddress);
        
        // Calculate subnet information
        int subnetBits = (int) Math.ceil(Math.log(n) / Math.log(2));
        int subnetIncrement = 256 / (int) Math.pow(2, subnetBits); 
        
        String[] netParts = networkAddress.split("\\.");
        
        System.out.println("Subnet Addresses:");
        for (int i = 0; i < n; i++) {
            int subnetPart = i * subnetIncrement;
            System.out.println("Subnet " + (i + 1) + ": " + netParts[0] + "." + netParts[1] + "." + netParts[2] + "." + subnetPart);
        }
    }
}
