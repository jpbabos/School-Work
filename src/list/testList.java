package list;
import java.util.*;
public class testList {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter list 1 size");
        int size1 = input.nextInt();
        System.out.println("Enter list 2 size");
        int size2 = input.nextInt();


        orderedList l = new orderedList(size1);
        orderedList t = new orderedList(size2);

        l.insert(-1);
        l.insert(1);
        l.insert(55);
        l.insert(8);
        l.insert(10);
        System.out.println("Your first array is: ");
        l.display();
        //l.delete(1);
        System.out.println("After deleting an entry, your first array now is: ");
        l.display();
        t.insert(5);
        t.insert(4);
        t.insert(66);
        t.insert(25);
        t.insert(2);
        t.insert(3);

        System.out.println("Your second array is: ");
        t.display();
        orderedList k = new orderedList(l.numOfItems + t.numOfItems);
        System.out.println("The two arrays merged: ");
        k.merge(l.list, t.list);
        k.display();
    }
}