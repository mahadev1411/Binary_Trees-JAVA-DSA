import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree_questions 
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
    public static void bfs(Node root) //iterative
    {
        System.out.print("bfs traversal is:");
        Queue<Node> q=new LinkedList<>();
        if(root!=null)
        q.add(root);
        while(q.size()>0)
        {
            Node temp=q.peek();
            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);

            System.out.print(temp.data+" ");
            q.remove();
        }
    }
    public static int height(Node root)
    {
        if(root==null || root.left==null || root.right==null)
        return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static boolean isBalanced(Node root) 
    {
        if(root==null)
        return true;
        int left=height(root.left);
        if(root.left!=null) left++;
        int right=height(root.right);
        if(root.right!=null) right++;
        if(Math.abs(left-right)>1)
        return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static boolean contains(Node root,Node node) //helper function for lowestCommonAncestor
    {
        if(root==null)
        return false;
        if(root==node)
        return true;
        return contains(root.left,node) || contains(root.right,node);
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) 
    {
        if(p==root || q==root)
        return root;
        if(p==q)
        return p;
        boolean left=contains(root.left,p);
        boolean right=contains(root.right,q);  
        if(left==true && right==true)
        return root;
        if(left==true && right==false)
        return lowestCommonAncestor(root.left,p,q);
        if(left==false && right==true)
        return lowestCommonAncestor(root.right,p,q);
        if(left==false && right==false)
        return root;

        return null;
    }
    public static void helper(Node root,List<String> ans,String s) //helper function for binaryTreePaths
    {
        if(root==null)
        return;
        if(root.left==null && root.right==null)
        {
            s=s+root.data;
            ans.add(s);
            return;
        }
        helper(root.left,ans,s+root.data+"->");          
        helper(root.right,ans,s+root.data+"->");         
    }                                                   
    public static List<String> binaryTreePaths(Node root) 
    {
        List<String> ans=new ArrayList<String>();
        helper(root,ans,"");
        return ans;
    }
    public static boolean isSameTree(Node p, Node q) 
    {
        if(p==null && q==null)
        return true;
        if(p==null || q==null)
        return false;
        
        if(p.data!=q.data)
        return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String[] args) 
    {
        // tree1->
        Node root=new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        root.left=a;
        root.right=b;
        Node c=new Node(10);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        System.out.print("bfs traversal order:");
        bfs(root);
        System.out.println();
        if(isBalanced(root))
        System.out.println("tree is balanced!");
        else
        System.out.println("tree is not balanced");
        ArrayList<String> temp=new ArrayList<String>(binaryTreePaths(root));
        System.out.println(temp);

        Node x=lowestCommonAncestor(root,b,d);
        System.out.println("lowest common ancestor of "+b.data+" "+d.data +" is "+x.data);

        // tree2->
        Node root1=new Node(1);
        Node a1=new Node(2);
        Node b1=new Node(3);
        root1.left=a1;
        root1.right=b1;
        Node c1=new Node(11);
        Node d1=new Node(5);
        a1.left=c1;
        a1.right=d1;
        if(isSameTree(root,root1))
        System.out.println("same trees!!");
        else
        System.out.println("trees are not same");
    }
}
