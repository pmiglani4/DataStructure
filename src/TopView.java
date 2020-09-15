import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
public class TopView {
    static void topView(Node root){
        if(root == null){
            return;
        }
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

        q.add(new QueueObj(root, 0));
        while (!q.isEmpty()){
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
            }
        }
        System.out.println("The top view of the tree is : ");
        for(Map.Entry<Integer, Node> entry: topViewMap.entrySet()) {
            System.out.println(entry.getValue().data);
        }

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        topView(tree.root);
        System.out.println("Following are nodes in top view of Binary Tree");
        topViewWithoutQueue(tree.root);
    }
    static class pair
    {
        int first, second;

        pair(){}
        pair(int i, int j)
        {
            first = i;
            second = j;
        }
    }

    static TreeMap<Integer,
            pair> m= new TreeMap<>();

    static void fillMap(Node root, int d, int l, Map<Integer, pair> m)
    {
        if(root==null){
            return;
        }
        if(m.containsKey(d)){
            if(m.get(d).second>l){
                m.put(d, new pair(root.data, l));
            }
        }else {
            m.put(d, new pair(root.data, l));
        }
        fillMap(root.left, d-1, l+1, m);
        fillMap(root.right, d+1, l+1, m);

    }

    static void topViewWithoutQueue(Node root){
        Map<Integer, pair> m= new TreeMap<>();
        fillMap(root, 0, 0, m);
        for (Map.Entry<Integer, pair> entry: m.entrySet()){
            System.out.println(entry.getValue().first);
        }
    }
}
