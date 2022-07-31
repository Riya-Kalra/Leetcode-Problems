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
    public void reorderList(ListNode head) {
      ListNode fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)
            slow=slow.next;
        ListNode h2=reverse(slow);
        ListNode h1= head;
        ListNode next=null,prev=null;
        while(h2!=null){
            next=h1.next;
            h1.next=h2;
            h2=h2.next;
            h1=h1.next;
            h1.next=next;
            h1=h1.next;
        }
        h1.next=null;
        return ;
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}