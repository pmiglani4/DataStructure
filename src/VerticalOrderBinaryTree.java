import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderBinaryTree {

    public static void main(String[] args) {
        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }



    private static void printVerticalOrder(Node root) {
        if(root == null){
            return;
        }
        TreeMap<Integer, List<Integer>> hdMap= new TreeMap<>();
        populateHdMap(root, hdMap, 0);
        for (Map.Entry<Integer, List<Integer>> entry:hdMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private static void populateHdMap(Node node, TreeMap<Integer, List<Integer>> hdMap, int hd) {
        if(node == null){
            return;
        }
        List<Integer> nodes;
        if(hdMap.containsKey(hd)){
            nodes = hdMap.get(hd);
        }else {
            nodes = new ArrayList<>();
        }
        nodes.add(node.data);
        hdMap.put(hd, nodes);
        populateHdMap(node.left, hdMap, hd-1);
        populateHdMap(node.right, hdMap, hd+1);
    }
}
