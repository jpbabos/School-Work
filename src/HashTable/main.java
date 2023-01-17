package HashTable;
import java.util.Scanner;
public class main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of hash table");
        HTable ht = new HTable(sc.nextInt() );

        char ch;
        String choice="null" ;

        do
        {
            System.out.println("Enter first letter of insert, delete, clear, find, records");
            choice = sc.next();
            switch (choice)
            {
                case "i" :
                    System.out.println("Enter ID, name");
                    ht.insert( sc.nextInt(), sc.next() );
                    break;
                case "d" :
                    System.out.println("Enter ID, name");
                    ht.remove( sc.nextInt() );
                    break;
                case "c":
                    ht.Empty();
                    System.out.println("Cleared the hash table");
                    break;
                case "f" :
                    System.out.println("Enter ID, name");
                    int val2=( sc.nextInt() );
                    if(ht.equals(val2))
                    {
                        System.out.println("Student found");
                    }
                    else
                    {
                        System.out.println("Student not found");
                    }
                    break;
                case "r":
                    ht.displayHashtable();
                    break;
                default :
                    System.out.println("You entered undefined choice...");
                    break;
            }
        } while (true);
    }
}