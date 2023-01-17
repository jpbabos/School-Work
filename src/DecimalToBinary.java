import java.util.*;
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num;
        boolean notDone = true;
        while (notDone) {
            System.out.println("Choose a number to be converted into binary");
            num = s.nextInt();
            StringBuilder binaryBuffer = new StringBuilder();
            while (num > 0) {
                int remainder = num % 2;
                binaryBuffer.append(remainder);
                num = num / 2;
            }
            //reverse the buffer and convert it to string
            String binaryNumber = binaryBuffer.reverse().toString();
            System.out.print("Your number converted into binary is: ");
            System.out.println(binaryNumber);
            System.out.println(" ");
        }
    }
}