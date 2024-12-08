class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}

class LinkedList {

    public static Node insertNode(Node head, int val, int k) {
        if (k == 0) {
            Node newNode = new Node(val);
            newNode.next = head;
            return newNode;
        }

        head.next = insertNode(head.next, val, k - 1);
        return head;
    }

    public static void display(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + "  ");
        display(head.next);
    }

    public static Node deleteNode(Node head, int val) {
        if (head == null) {
            // meaning that value is not to be found
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        head.next = deleteNode(head.next, val);

        return head;

    }
}

public class BuildingLinkedList {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(1);
        head.next.next.next = new Node(8);

        LinkedList.insertNode(head, 10, 1);
        LinkedList.display(head);

        LinkedList.deleteNode(head, 10);
        System.out.println();
        LinkedList.display(head);
    }
}
