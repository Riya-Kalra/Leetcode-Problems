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
    public boolean isPalindrome(ListNode h) {
        ListNode fast=h,slow=h,head=h,head1=null;
        while(fast!=null &&fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast==null)
            head1=reverse(slow);
        else
            head1=reverse(slow.next);
        while(head1!=null){
            if(head1.val!=head.val)
                return false;
            head1=head1.next;
            head=head.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode curr){
        ListNode prev=null, next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}