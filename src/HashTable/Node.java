package HashTable;

public class Node {
    int data;
    String name;
    Node left;
    Node right;

    public Node(int data, String name){
        this.data = data;
        this.name = name;
    }
    public void display(){
        System.out.println(data + ", " + name );
    }
}
