package HashTable;

public class HTable {
    private Node[] t;
    private int size ;

    public HTable(int tableSize)
    {
        t = new Node[ nextPosition(tableSize) ];
        size = 0;
    }
    public void Empty()
    {
        int l = t.length;
        t = new Node[l];
        size = 0;
    }


    public void insert(int val, String N)
    {
        size++;
        int pos = myHashtable(val);
        Node head = t[pos];
        head = insert(head, val, N);
        t[pos] = head;
    }
    private Node insert(Node node, int data, String name)
    {
        if (node == null)
            node = new Node(data, name);
        else
        {
            if (data <= node.data)
                node.left = insert(node.left, data, name);
            else
                node.right = insert(node.right, data, name);
        }
        return node;
    }

    public void remove(int val)
    {
        int pos = myHashtable(val);
        Node head = t[pos];
        try
        {
            head = delete(head, val);
            size--;
        }
        catch (Exception e)
        {
            System.out.println("\nElement not present\n");
        }
        t[pos] = head;
    }

    private Node delete(Node head, int k)
    {
        Node a, b, n;
        if (head.data == k)
        {
            Node lt, rt;
            lt = head.left;
            rt = head.right;
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                a = rt;
                return a;
            }
            else if (rt == null)
            {
                a = lt;
                return a;
            }
            else
            {
                b = rt;
                a = rt;
                while (a.left != null)
                    a = a.left;
                a.left = lt;
                return b;
            }
        }
        if (k < head.data)
        {
            n = delete(head.left, k);
            head.left = n;
        }
        else
        {
            n = delete(head.right, k);
            head.right = n;
        }
        return head;
    }

    private int myHashtable(Integer x )
    {
        int hashVal = x.hashCode( );
        hashVal %= t.length;
        if (hashVal < 0)
            hashVal += t.length;
        return hashVal;
    }

    private static int nextPosition( int r )
    {
        if (r % 2 == 0)
            r++;
        for ( ; !isNext( r ); r += 2);

        return r;
    }
    private static boolean isNext( int r )
    {
        if (r == 2 || r == 3)
            return true;
        if (r == 1 || r % 2 == 0)
            return false;
        for (int i = 3; i * i <= r; i += 2)
            if (r % i == 0)
                return false;
        return true;
    }

    public void displayHashtable ()
    {
        System.out.println();
        for (int i = 0; i < t.length; i++)
        {
            System.out.print ( i + ": ");
            inorder(t[i]);
            System.out.println();
        }
    }

    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data + ", " + r.name );
            inorder(r.right);
        }
    }
}
