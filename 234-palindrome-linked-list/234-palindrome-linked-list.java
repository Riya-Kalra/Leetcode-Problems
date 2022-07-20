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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=head, end=head,prev=null;
        while(end!=null && end.next!=null){
            
            mid=mid.next;
            end=end.next.next;
        }
        
        if (end != null) { // odd nodes: let right half smaller
        mid= mid.next;
        }
        ListNode head2=reverse (mid);
        
        //System.out.println(head2.val);
        ListNode head1=head;
        while(head2!=null){
            if(head1==null || head1.val!=head2.val)
                return false;
            head1=head1.next;
            head2=head2.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode curr){
        ListNode prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}