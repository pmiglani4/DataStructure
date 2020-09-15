public class LargestBST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(10);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(20);
        tree.root.right.left = new Node(55);
        tree.root.right.left.left = new Node(45);
        tree.root.right.right = new Node(70);
        tree.root.right.right.left = new Node(65);
        tree.root.right.right.right = new Node(80);

        System.out.println("size of largest BST is:"+tree.largestBst(tree.root));
        System.out.println("size of largest BST is:"+tree.largestBstOptimized(tree.root).ans);
    }
}
