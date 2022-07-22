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
    public ListNode partition(ListNode head, int x) {
        ListNode less=new ListNode(0),greater=new ListNode(0);
        ListNode curr=head,l1=less,g1=greater;
        while(curr!=null){
            if(curr.val<x){
                less.next=curr;
                less=less.next;
            }
            else{
                greater.next=curr;
                greater=greater.next;
            }
            curr=curr.next;
        }
        greater.next=null;
        g1=g1.next;
        less.next=g1;
        l1=l1.next;
        return l1;
        
    }
}