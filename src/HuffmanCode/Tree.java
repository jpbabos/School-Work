package HuffmanCode;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
public class Tree {

    private Node root;
    private String[] codeTable;
    private String huffmanCode;

    public Tree(String initString)
    {
        huffmanCode = new String();
        codeTable = new String[128];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String s = initString;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            if(val != null)
                map.put(c, val + 1);
            else
                map.put(c, 1);
        }
        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            String key = Character.toString(entry.getKey());
            Integer value = entry.getValue();
            Node tempNode = new Node();
            tempNode.sData = key;   //node contains character
            tempNode.iData = value; //and frequency of character
            nodeQueue.add(tempNode);
        }
        while(nodeQueue.size() > 1) {
            Node temp1 = nodeQueue.remove();
            Node temp2 = nodeQueue.remove();
            Node newTree = new Node();
            newTree.iData = temp1.iData + temp2.iData;
            newTree.leftChild = temp1;
            newTree.rightChild = temp2;
            nodeQueue.add(newTree);
        }
        root = nodeQueue.remove();
        System.out.println("Creating code table...");
        createTable(root);
        System.out.println(" done");
    }
    public void createTable(Node localRoot) {
        if(localRoot.sData != null) {
            char temp = localRoot.sData.charAt(0);
            int index = (int)temp;
            codeTable[index] = huffmanCode;
            System.out.println("Generated (" + codeTable[index] + ") at index " + index);
            return;
        }
        else {
            huffmanCode += "0";
            createTable(localRoot.leftChild);
            huffmanCode = huffmanCode.substring(0, huffmanCode.length()-1);
            huffmanCode += "1";
            createTable(localRoot.rightChild);
            huffmanCode = huffmanCode.substring(0, huffmanCode.length()-1);
        }
    }
    public String encode(String message) {
        String result = new String();
        for(int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            int index = (int)temp;
            result += codeTable[index];
        }
        return result;
    }
    public String decode(String codedMessage) {
        String result = new String();
        Node temp = root;
        int i = 0;
        while(i < codedMessage.length()) {
            if(temp.sData == null) {
                if(codedMessage.charAt(i) == '0') {temp = temp.leftChild;}
                else if(codedMessage.charAt(i) == '1') {temp = temp.rightChild;}
                i++;
            }
            else {
                result += temp.sData;
                temp = root;
            }
        }
        result += temp.sData;
        return result;
    }
    public void traverse(int traverseType) {
        switch(traverseType) {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println("");
    }
    private void preOrder(Node localRoot) {
        if(localRoot != null) {
            System.out.print(localRoot.sData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    private void inOrder(Node localRoot) {
        if(localRoot != null) {
            System.out.print("(");
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.sData + " ");
            inOrder(localRoot.rightChild);
            System.out.print(")");
        }
    }

    private void postOrder(Node localRoot) {
        if(localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.sData + " ");
        }
    }
    public void displayTree() {
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                ".......................................................");
        while(isRowEmpty==false) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;
            for(int j = 0; j < nBlanks; j++)
                System.out.print(" ");
            while(globalStack.isEmpty() == false) {
                Node temp = globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.sData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j = 0; j < nBlanks*2 - 2; j++)
                    System.out.print(" ");
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty() == false)
                globalStack.push( localStack.pop() );
        }
        System.out.println(
                ".......................................................");
    }
}
