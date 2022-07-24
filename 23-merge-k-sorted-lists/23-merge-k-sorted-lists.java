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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 )
            return null;
      ListNode head=lists[0];
        for(int i=1;i<lists.length;i++){
            head=merge(head,lists[i]);
        }
        return head;
    }
    public ListNode merge(ListNode head, ListNode h){
        ListNode curr= new ListNode(0);
        ListNode ptr=curr;
        while(head!=null && h!=null){
            if(head.val<h.val){
                curr.next=head;
                head=head.next;
            }
            else{
               curr.next=h;
                h=h.next; 
            }
            curr=curr.next;
        }
        if(head!=null)
            curr.next=head;
        if(h!=null)
            curr.next=h;
        return ptr.next;
    }
}