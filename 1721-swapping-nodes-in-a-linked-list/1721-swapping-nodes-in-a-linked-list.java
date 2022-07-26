/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        // finding the first node
        for(int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        
        ListNode first = fast;
        
        // finding the second node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode second = slow;
        
        // swapping the first and second node values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}