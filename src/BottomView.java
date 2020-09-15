import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        BinaryTree tree = new BinaryTree();
        tree.root=root;
        System.out.println("Following are nodes in bottom view of Binary Tree");
        bottomView(root);
        System.out.println("Following are nodes in bottom view of Binary Tree");
        bottomViewWithoutQueue(root);
    }

    static class QueueObj {
        Node node;
        int hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    private static void bottomView(Node root) {
        if(root==null){
            return;
        }
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<QueueObj> q= new LinkedList<>();
        q.add(new QueueObj(root, 0));
        while (!q.isEmpty()){
            QueueObj temp= q.poll();
            bottomViewMap.put(temp.hd, temp.node.data);
            if(temp.node.left!=null){
                q.add(new QueueObj(temp.node.left, temp.hd-1));
            }
            if(temp.node.right!=null){
                q.add(new QueueObj(temp.node.right, temp.hd+1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : bottomViewMap.entrySet())
        {
            System.out.println(entry.getValue());
        }

    }

    static class Pair {
        Integer nodeValue;
        int height;

        Pair(Integer nodeValue, int height) {
            this.nodeValue = nodeValue;
            this.height = height;
        }
    }

    static void bottomViewWithoutQueue(Node root) {
        Map<Integer, Pair> m = new TreeMap<>();
        fillMap(root, 0, 0, m);
        for (Map.Entry<Integer, Pair> entry:m.entrySet()){
            System.out.println(entry.getValue().nodeValue);
        }
    }

    private static void fillMap(Node root, int d, int l, Map<Integer, Pair> m) {
        if(root==null)
            return;
        if(!m.containsKey(d)){
            m.put(d, new Pair(root.data, l));
        }else if(m.get(d).height<=l){
            m.put(d, new Pair(root.data, l));
        }

        fillMap(root.left, d-1, l+1, m);
        fillMap(root.right, d+1, l+1, m);
    }
}
