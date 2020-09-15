import java.util.Map;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BstRes{
    int min;
    int max;
    int ans;
    int size;
    public BstRes(){

    }
    public BstRes(int min, int max, int ans, int size, boolean isBST) {
        this.min = min;
        this.max = max;
        this.ans = ans;
        this.size = size;
        this.isBST = isBST;
    }

    boolean isBST;
}
class BinaryTree{
    Node root;
    Node prev;

    int findMaxSum(){

        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        findMaxSumUtil(root, res);
        return  res.val;
    }

    private int findMaxSumUtil(Node node, Res res) {
        if (node == null)
            return 0;
        int l= findMaxSumUtil(node.left, res);
        int r=findMaxSumUtil(node.right, res);
        int max_single = Math.max(node.data, node.data+Math.max(l,r));

        int max_top =Math.max(max_single, l+r+node.data);
        res.val= Math.max(res.val, max_top);
        return  max_single;

    }

    public boolean isBST(Node root) {
        return  isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST() {
        return  isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTInorder() {
        prev=null;
        return  isBstInorderUtil(root);
    }

    private boolean isBstInorderUtil(Node root) {
        if(root==null){
            return true;
        }
        if (!isBstInorderUtil(root.left)){
            return false;
        }
        if (prev !=null && root.data<= prev.data){
            return false;
        }
        prev=root;
        return  isBstInorderUtil(root.right);
    }

    private boolean isBstUtil(Node root, int minValue, int maxValue) {
        if(root==null)
            return true;
        if(root.data<minValue || root.data>maxValue){
            return false;
        }
        return isBstUtil(root.left, minValue, root.data-1)&&isBstUtil(root.right, root.data+1, maxValue);
    }

    public  int largestBst(Node root){
        if(isBST(root)){
            return size(root);
        }
        return Math.max(largestBst(root.left), largestBst(root.right));
    }

    public  BstRes largestBstOptimized(Node root){
        if(root == null){
           return new BstRes(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, true);
        }
        if (root.left == null && root.right == null)
            return new BstRes(root.data, root.data, 1,1, true);
        BstRes left = largestBstOptimized(root.left);
        BstRes right = largestBstOptimized(root.right);
        BstRes result = new BstRes();
        result.size=1+left.size+right.size;
        if(left.isBST && right.isBST && left.max<root.data && right.min>root.data){
            result.ans=result.size;
            result.isBST=true;
            result.min=Math.min(left.min, Math.min(root.data, right.min));
            result.max=Math.max(right.max, Math.max(root.data, left.max));
            return  result;
        }
        result.ans=Math.max(left.ans, right.ans);
        result.isBST=false;
        return result;

    }

    private int size(Node root) {
        if(root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
}
class Res{
    int val;
}

public class MaxPathBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSum());
    }
}
