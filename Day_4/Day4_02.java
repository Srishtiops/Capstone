//PriorityQueue(Min Heap)
//ArrayList
//MinHeap (parent element <= other than all element)

//each node(object) has
//val -- > data
//next --> pointer to next node

import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class Day4_02{
    public static void main(String[] args){
        //create list 1 : 1 --> 4 --> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        //create list 2 : 1 --> 3 --> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        //create list 3 : 2 --> 6
        ListNode l3 = new ListNode(2);  
        l3.next = new ListNode(6);

        //put all lists into array
        ListNode[] lists = {l1, l2, l3};

        //call function
        ListNode result = mergeLists(lists);

        //print result
        System.out.print("Merged List: ");
        printList(result);
    }
    static void printList(ListNode head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    static ListNode mergeLists(ListNode[] lists){
        //heap stores nodes based on smallest value first
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);

        //add first node of each list.
        for (ListNode node : lists) {
            //initially add: head of each list
            //because min heap
            if (node != null) {
                pq.add(node);
            }
        }

        //-1 is just a placeholder value, it has no real meaning in our code
        //dummy simplifies list creation
        //dummy node is used to simplify list construction,  not for storing data
        //curr is used to build result
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //main loop
        //loop run until heap is empty
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();

            //add to result
            //attach node to result list
            curr.next = minNode;
            curr = curr.next;

            //ensure next element of that list is considered
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        //return result
        //skip dummy and return actual list
        return dummy.next;
    }


}    

//Time Complexity: 
//O(N log K)
//N = Total nodes
//K = Total lists