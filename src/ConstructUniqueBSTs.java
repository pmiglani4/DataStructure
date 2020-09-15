import java.util.ArrayList;

public class ConstructUniqueBSTs {
    public static void main(String args[])
    {
        ArrayList<Node> totalTreesFrom1toN = constructTrees(1, 3);
        /*  Printing preorder traversal of all constructed BSTs   */
        System.out.println("Preorder traversals of all constructed BSTs are ");
        for (int i = 0; i < totalTreesFrom1toN.size(); i++)
        {
            preorder(totalTreesFrom1toN.get(i));
            System.out.println();
        }
    }


    private static void preorder(Node node) {
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    private static ArrayList<Node> constructTrees(int start, int end) {
        ArrayList<Node> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<Node> leftSubTrees = constructTrees(start, i - 1);
            ArrayList<Node> rightSubTrees = constructTrees(i + 1, end);
            for (int x = 0; x < leftSubTrees.size(); x++) {
                Node leftSubTreeRoot = leftSubTrees.get(x);
                for (int y = 0; y < rightSubTrees.size(); y++) {
                    Node rightSubTreeRoot = rightSubTrees.get(y);
                    Node root = new Node(i);
                    root.left = leftSubTreeRoot;
                    root.right = rightSubTreeRoot;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
