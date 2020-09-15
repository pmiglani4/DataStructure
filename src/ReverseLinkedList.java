public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}
