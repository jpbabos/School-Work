package Tree234;

public class Tree {
    private Node root;

    public Tree(){
        root = new Node();
    }
    public Node getNextChild(Node n, int id){
        int numItems = n.getNumItems();
        int i;
        for(i = 0 ; i < numItems ;i++){
            if(id < n.getStudent(i).id)
                return n.getChild(i);
        }
        return n.getChild(i);
    }
    public int search(int id){
        Node curr = root;
        int childNo;
        while(true){
            childNo = curr.findStudent(id);
            if(childNo != -1)
                return childNo;
            else if(curr.isLeaf())
                return -1;
            else
                curr = getNextChild(curr,id);
        }
    }
    public void insert(Student s){
        Node curr = root;

        while(true){
            if(curr.isFull()){
                split(curr); // split is done
                curr = curr.getParent();//go up a level and restart search
            }
            else if(curr.isLeaf())
                break;
            else
                curr = getNextChild(curr , s.id);
        }
        curr.insertStudent(s);
    }
    public void split(Node n){
        Student B, C;
        Node parent, child2, child3;
        C = n.removeStudent();
        B = n.removeStudent();
        child2 = n.disconnectChild(2);
        child3 = n.disconnectChild(3);

        Node newNode = new Node();
        if(n == root){
            root = new Node();
            parent = root;
            root.connectChild(n, 0);
        }
        else{
            parent = n.getParent();
        }
        int index = parent.insertStudent(B);
        int num = parent.getNumItems();

        for(int i = num-1; i > index ; i--){
            Node temp = parent.disconnectChild(i);
            parent.connectChild(temp, i+1);
        }
        parent.connectChild(newNode, index+1);

        newNode.insertStudent(C);
        newNode.connectChild(child2, 0);
        newNode.connectChild(child3, 1);
    }
    public void inorderTraversal() {
        inorderTraversal(root);
    }
    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getChild(0));
            if (node.getStudent(0) != null)
                System.out.println(node.getStudent(0));
            inorderTraversal(node.getChild(1));
            if (node.getStudent(1) != null)
                System.out.println(node.getStudent(1));
            inorderTraversal(node.getChild(2));
            if (node.getStudent(2) != null)
                System.out.println(node.getStudent(2));
            inorderTraversal(node.getChild(3));
        }
    }
}