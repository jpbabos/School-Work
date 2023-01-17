package HashTable;

public class BST {
    private Node root;
    public BST(){
        root = null;
    }
    public Node search(int key){
        Node curr = root;
        while(curr.data != key){
            if(key < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
            if(curr == null)
                return null;
        }
        return curr;
    }
    public void insert(int value, String student){
        Node newNode = new Node(value, student);
        if(root == null)
            root = newNode;
        else{ //non-empty tree
            Node curr = root;
            Node parent;
            while(true){
                parent = curr;
                if(value < curr.data){
                    curr = curr.left;
                    if(curr == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    curr = curr.right;
                    if(curr == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node localRoot){
        if(localRoot != null){
            inorder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inorder(localRoot.right);
        }
    }
    public Node min(){
        Node curr = root;
        Node parent = root;
        while(curr != null){
            parent = curr;
            curr = curr.left;
        }
        return parent;
    }
    public boolean delete(int key){
        Node curr = root;
        Node parent = root;
        boolean isLeft = true;

        while(curr.data != key){
            parent = curr;
            if(key < curr.data){
                curr = curr.left;
                isLeft = true;
            }
            else{
                curr = curr.right;
                isLeft = false;
            }
            if(curr == null)
                return false;
        }
        //check for leaf node
        if(curr.left == null && curr.right == null){
            if(curr == root)
                root = null;
            else if(isLeft)
                parent.left = null;
            else
                parent.right = null;
        }
        //delete node with one child
        else if(curr.right == null){
            if(curr == root)
                root = curr.left;
            else if(isLeft)
                parent.left = curr.left;
            else
                parent.right = curr.left;
        }
        else if(curr.left == null){
            if(curr == root)
                root = curr.right;
            else if(isLeft)
                parent.left = curr.right;
            else
                parent.right = curr.right;
        }
        //delete a node with two children
        else{
            Node succ = getSuccessor(curr);

            if(curr == root)
                root = succ;
            else if(isLeft)
                parent.left = succ;
            else
                parent.right = succ;
            succ.left = curr.left;
        }
        return true;
    }
    public Node getSuccessor(Node delNode){
        Node succ = delNode;
        Node succParent = delNode;
        Node curr = delNode.right;
        while(curr != null){
            succParent = succ;
            succ = curr;
            curr = curr.left;
        }
        if(succ != delNode.right){
            succParent.left = succ.right;
            succ.right = delNode.right;
        }
        return succ;
    }
}

