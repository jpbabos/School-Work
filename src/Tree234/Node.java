package Tree234;

public class Node {
    final int ORDER = 4;
    private Student[] StudentArray = new Student[3];
    private Node[] childArray = new Node[4];
    private int numItems;
    private Node parent;

    public Node(){}
    public int insertStudent(Student s){
        numItems++;
        for(int i = ORDER-2; i >= 0 ; i--){
            if(StudentArray[i] == null)
                continue;
            else{
                if(s.id < StudentArray[i].id)
                    StudentArray[i+1] = StudentArray[i];
                else{
                    StudentArray[i+1] = s;
                    return i+1;
                }
            }
        }
        StudentArray[0] = s;
        return 0;
    }
    public Student removeStudent(){
        Student temp = StudentArray[numItems-1];
        StudentArray[numItems-1] = null;
        numItems--;
        return temp;
    }
    public boolean isLeaf(){
        return childArray[0] == null;
    }
    public int getNumItems() {
        return numItems;
    }
    public Node getParent() {
        return parent;
    }
    public Student getStudent(int index){
        return StudentArray[index];
    }
    public Node getChild(int index){
        return childArray[index];
    }
    public boolean isFull(){
        return numItems == 3;
    }
    public int findStudent(int id){
        for(int i = 0 ; i < numItems ; i++){
            if(StudentArray[i].id == id)
                return i;
        }
        return -1;
    }
    public Node disconnectChild(int index){
        Node temp = childArray[index];
        childArray[index] = null;
        return temp;
    }
    public void connectChild(Node n,int index){
        childArray[index] = n;
        if(n != null)
            n.parent = this;
    }
    public int displayNode(){
        for(int i = 0 ; i < numItems; i++){
            System.out.println(StudentArray[i].toString());
        }
        return 0;
    }
}
