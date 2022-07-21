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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        if(head==null || head.next==null)
            return head;
        int c=1;
        while(c<left){
            curr=curr.next;
            c++;}
        
        ListNode prev=curr;
        curr=curr.next;
        c++;
       
        ListNode p=null,next=null;
        while(c++<=right){
            next=curr.next;
            curr.next=p;
            p=curr;
            curr=next;
        }
        next=curr.next;
        curr.next=p;
        prev.next=curr;
        while(curr.next!=null)
            curr=curr.next;
        curr.next=next;
        return dummy.next;
    }
}