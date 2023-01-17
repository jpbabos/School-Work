package CircularLinkedList;

public class TestClass {
    public static void main(String[] args) {
        LinkList cll = new LinkList();
        cll.display();
        cll.insert(5);
        cll.insert(100);
        cll.insert(58);
        cll.insert(67);
        cll.display();
        Node f = cll.search(100);
        if (f != null) {

        }
        Node d = cll.delete(58);
        if (d != null) {
            System.out.print("Deleted Node: ");
            d.displayLink();
        }
        cll.insert(45);
        cll.insert(73);
        cll.display();

        while(cll.curr != null) {
            Node t = cll.delete(cll.curr.value);
            System.out.print("Deleted Node: ");
            t.displayLink();
        }
        cll.display();
    }

}
