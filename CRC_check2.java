import java.util.Scanner;
class CRC_check2 {
    static String xor(String a, String b) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            res.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return res.toString();
    }
    static String divide(String msg, String poly) {
        String div = msg + "0".repeat(poly.length() - 1);
        String temp = div.substring(0, poly.length());
        for (int i = poly.length(); i <= div.length(); i++) {
            if (temp.charAt(0) == '1') {
                temp = xor(poly, temp) + (i < div.length() ? div.charAt(i) : "");
            } else {
                temp = xor("0".repeat(poly.length()), temp) + (i < div.length() ? div.charAt(i) : "");
            }
            temp = temp.substring(1);        }
        return temp;
    }
    static boolean isValid(String msg, String poly) {
        String rem = divide(msg, poly);
        return rem.equals("0".repeat(poly.length() - 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = sc.nextLine();
        System.out.print("Enter divisor: ");
        String poly = sc.nextLine();
        String crc = divide(msg, poly);
        System.out.println("CRC: " + crc);
        String transmitted = msg + crc;
        System.out.println("Transmitted message: " + transmitted);
        System.out.print("Enter received message: ");
        String received = sc.nextLine();
        if (isValid(received, poly)) {
            System.out.println("No error detected.");
        } else {
            int errorPos = -1;
            for (int i = 0; i < Math.min(transmitted.length(), received.length()); i++) {
                if (transmitted.charAt(i) != received.charAt(i)) {
                    errorPos = i;
                    break;
                }
            }
            System.out.println(errorPos == -1 ? "Error detected but position unknown." :
                    "Error detected at bit position: " + errorPos);
        }
    }
}
