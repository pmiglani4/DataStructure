public class BinaryTreeToDLL {

    static Node head;
    static Node prev=null;

    // Utility function for printing double linked list.
    static void printList(Node head)
    {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    static void BToDLL(Node root){
        if(root==null){
            return;
        }
        BToDLL(root.right);

        root.right=head;
        if(head!=null)
            head.left=root;
        head=root;
        BToDLL(root.left);
    }

    // Driver program to test the above functions
    public static void main(String[] args)
    {
        /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9  */

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);

        /*BToDLL(tree.root);
        printList(head);
        head=null;*/
        BinaryTree2DoubleLinkedList(tree.root);
        printList(head);


    }

    static void BinaryTree2DoubleLinkedList(Node root){
        if (root==null){
            return;
        }
        BinaryTree2DoubleLinkedList(root.left);


        if(prev==null){
            head=root;
        }else {
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        BinaryTree2DoubleLinkedList(root.right);
    }
}
