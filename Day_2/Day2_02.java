// Q. Uses floyd's algorithm to detect a cycle in a linked list and remove the cycle.

// This class represents a single node in a linked list.
class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val=val;
        this.next=null;
    }
 
}

public class Day2_02 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        // Node 50 pointer to node 20, creating a cycle in the linked list.
        head.next.next.next.next.next = head.next;

        boolean hasCycle = detectCycle(head);
        printList(head);
       
    }
    static boolean detectCycle(ListNode head){
        ListNode slow=head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) // This is the meeting point.
            {
                removeCycle(slow, head);
                return true;
            }
        }
        return false;
    }
    static void removeCycle(ListNode meetingPoint, ListNode head){
        ListNode start=head;
        while(start.next!=meetingPoint.next){
            start= start.next;
            meetingPoint = meetingPoint.next;
        }
        meetingPoint.next=null;
    }
    static void printList(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.val+" ");
            current=current.next;
        }
        System.out.println();
    }

}