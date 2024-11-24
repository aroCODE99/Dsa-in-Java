class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PartitonList {
    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating and linking nodes
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        // Displaying the original list
        System.out.print("Original list: ");
        display(head);

        int k = 3;
        // Partitioning the list with pivot value 3
        ListNode partitionedHead = partitionedList(head, k);
        System.out.print("Partitioned list: ");
        display(partitionedHead);
    }

    private static ListNode partitionedList(ListNode head, int x) {
        ListNode lesserHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode tempLess = lesserHead;
        ListNode tempHigh = greaterHead;

        while (head != null) {
            if (head.val < x) {
                tempLess.next = head;
                tempLess = tempLess.next;
            } else {
                tempHigh.next = head;
                tempHigh = tempHigh.next;// this will set this function in loop
            }
            head = head.next;
        }
        tempLess.next = greaterHead.next;
        tempHigh.next = null;// ensure that tempHig.next is marked null
        return lesserHead.next;
    }
}
