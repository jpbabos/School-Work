package CircularLinkedList;

public class LinkList {
    public Node curr;
    LinkList() {
        this.curr = null;
    }
    public void display() {
        if (this.curr == null) {
            System.out.println("List is empty");
            return;
        }
        Node check = this.curr;
        boolean flag = true;
        while (this.curr != check || flag){
            curr.displayLink();
            flag = false;
            step();
        }
    }

    public void insert(int val) {
        if (this.curr == null) {
            this.curr = new Node(val);
            this.curr.next = this.curr;
            return;
        }
        this.curr.next = new Node(val, this.curr.next);
    }
    public Node search(int val) {
        if (this.curr == null) {
            System.out.println("Item not found");
            return null;
        }
        Node check = this.curr;
        boolean flag = true;
        while (this.curr != check || flag){
            if (this.curr.value == val) {
                return this.curr;
            }
            flag = false;
            step();
        }
        return null;
    }
    public Node delete(int value) {
        if (this.curr == null)
            return null;
        if (this.curr.next == this.curr) {
            Node deleted = this.curr;
            this.curr = null;
            return deleted;
        }
        Node check = this.curr;
        boolean flag = true;
        while (this.curr != check || flag){
            if (this.curr.next.value == value) {
                Node deleted = this.curr.next;
                this.curr.next = this.curr.next.next;
                return deleted;
            }
            flag = false;
            step();
        }
        return null;
    }
    public void step() {
        this.curr = this.curr.next;
    }
}
