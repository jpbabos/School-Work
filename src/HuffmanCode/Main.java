package HuffmanCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        int value;
        String initString = "This was very difficult, and I never want to do it again haha";
        String encoded = new String();
        String decoded = new String();
        Tree theTree = new Tree(initString);

        while(true) {
            System.out.print("Enter first letter of decode, encode, show tree, or traverse: ");
            int choice = getChar();
            switch(choice) {
                case 'e':
                    encoded = theTree.encode(initString);
                    System.out.println(encoded);
                    break;
                case 'd':
                    decoded = theTree.decode(encoded);
                    System.out.println(decoded);
                    break;
                case 's':
                    theTree.displayTree();
                    break;
                case 't':
                    System.out.print("Enter type 1, 2, or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry!\n");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
