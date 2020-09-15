class LinkedList<Q> {
    Node head;  // head of list

    public Node reverse(Node head, int k) {
        int count =0;
        Node current = head;
        Node next=null;
        Node prev=null;
        while(count<k&&current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        if(next!=null)
            head.next=reverse(next,k);
        return prev;

    }

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void rotate(int k){
        if (k==0)
            return;
        Node current = head;
        int count =1;
        while(count<k && current != null){
            current=current.next;
            count++;
        }
        if(current==null){
            return;
        }

        Node kthNode = current;
        while (current.next!=null){
            current=current.next;
        }
        current.next=head;
        head=kthNode.next;
        kthNode.next=null;

    }

    void reArrange(){
        if (head==null)
            return;
        Node current = head;
        while (current!=null){
            Node temp = current;
            Node prev= temp;
            Node next=current.next;
            while (temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            if(prev!=temp){
                prev.next=null;
                temp.next=current.next;
                current.next=temp;
            }
            current=next;

        }
    }
    void reArrange1() {
        if (head == null)
            return;
        Node mid=findMid();
        Node secondHalfHead = mid.next;
        mid.next=null;
        Node reversedSecondHalf = reverseList(secondHalfHead);
        head = merge(head, reversedSecondHalf);

    }

    private Node merge(Node head1, Node head2) {
        Node newRoot;
        if(head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        Node current1=head1, current2=head2;
        Node temp1=head1, temp2=head2;
        while (current1!=null && current2!=null){
            temp1=current1.next;
            current1.next=current2;
            temp2=current2.next;
            current2.next=temp1;
            current1=temp1;
            current2=temp2;
        }
        return head1;
    }

    Node findMid(){
        if(head==null)
            return null;
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;

    }
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node reverseList(Node root){
        Node current = root;
        Node prev=null, next=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    Node reArrange2(Node head)
    {
        if (head == null) // Base case.
            return null;

        // two pointer variable.
        Node prev = head, curr = head.next;

        while (curr != null)
        {
            // swap function for swapping data.
            if (prev.data > curr.data)
            {
                int t = prev.data;
                prev.data = curr.data;
                curr.data = t;
            }

            // swap function for swapping data.
            if (curr.next != null && curr.next.data > curr.data)
            {
                int t = curr.next.data;
                curr.next.data = curr.data;
                curr.data = t;
            }

            prev = curr.next;

            if (curr.next == null)
                break;
            curr = curr.next.next;
        }
        return head;
    }
}
public class RotateLinkedlist {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<Integer>();

        // create a list 10->20->30->40->50->60
        for (int i = 60; i >= 10; i -= 10)
            llist.push(i);

        System.out.println("Given list");
        llist.printList();

        llist.rotate(6);

        System.out.println("Rotated Linked List");
        llist.printList();

        llist.reArrange2(llist.head);
        System.out.println("Reordered Linked List");
        llist.printList();

        LinkedList.Node mid = llist.findMid();
        System.out.println("Mid element is:"+ mid.data);
        int count[] =new int[256];
        System.out.println(count[12]);

    }

}
