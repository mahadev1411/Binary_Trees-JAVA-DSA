public class basics
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
        }
    }
    public static void preorder(Node root)
    {
        if(root==null)
        return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void nthLevel(Node root,int n)
    {
        if(root==null)
        return;
        if(n==1)
        {
            System.out.print(root.data+" ");
            return;
        }

        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
    }
    public static int size(Node root)
    {
        if(root==null)
        return 0;
        return size(root.left)+size(root.right)+1;
    }
    public static int sum(Node root)
    {
        if(root==null)
        return 0;

        return root.data+sum(root.left)+sum(root.right);
    }
    public static int product(Node root)
    {
        if(root==null)
        return 1;

        return root.data*product(root.left)*product(root.right);
    }
    public static int max(Node root)
    {
        if(root==null)
        return Integer.MIN_VALUE;

        return Math.max(Math.max(max(root.left),max(root.right)),root.data);
    }
    public static int height(Node root)
    {
        if(root==null) 
        return 0;

        if(root!=null && root.left==null && root.right==null)
        return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }
    public static int min(Node root)
    {
        if(root==null)
        return Integer.MAX_VALUE;

        return Math.min(Math.min(min(root.left),min(root.right)),root.data);
    }
    public static void main(String[] args) 
    {
        Node root=new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        root.left=a;
        root.right=b;
        Node c=new Node(10);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        System.out.print("Preorder traversal is: ");
        preorder(root);
        System.out.println();
        System.out.print("Inorder traversal is: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder traversal is: ");
        postorder(root);
        System.out.println();
        System.out.print("Nth level nodes are: ");
        nthLevel(root, 2);
        System.out.println();
        System.out.println("size of tree is: "+size(root));
        System.out.println("sum of nodes is: "+sum(root));
        System.out.println("Product of nodes is: "+product(root));
        System.out.println("Maximum node is: "+max(root));
        System.out.println("Minimum node is: "+min(root));
        System.out.println("height of the tree is: "+height(root));
        System.out.println("Printing Nodes at each level:");
        int level=height(root)+1; //number of levels in tree is always 1 more than it's height
        for(int i=1;i<=level;i++)
        {
            nthLevel(root, i);//every iteration assume we are printing nodes at 'i'th  level
            System.out.println(); 
        } //T.C => O(N*LOG(N))

    }
}