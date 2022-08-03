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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ||k==0) return head;
        ListNode fast=head;
        int i=0;
        while(i<k && fast!=null){
            fast=fast.next;
            i++;
        }
        if(fast==null){
            k=k%i;
            if(k==0) return head;
            i=0;fast=head;
            while(i<k){
                fast=fast.next;
                i++;
            }
        }
            
        ListNode slow=head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode curr=slow.next;
        slow.next=null;
        ListNode h2=curr;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        return h2;
    }
}