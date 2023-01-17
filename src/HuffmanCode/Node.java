package HuffmanCode;

public class Node implements Comparable<Object>{
    public String sData;
    public Integer iData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print("{" + sData + ", " + iData + "}");
    }
    public int compareTo(Object o) {
        Node node = (Node)o;
        return (this.iData - node.iData);
    }
}
