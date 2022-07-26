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
       int c=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            c++;
        }
        ListNode ptr=head,ctr=head;
        int i=0,j=0;
        while(i<k-1){
            ptr=ptr.next;
            i++;
        }
        while(j<c-k){
            ctr=ctr.next;
            j++;
        }
        int t=ptr.val;
        ptr.val=ctr.val;
        ctr.val=t;
        return head;
    }
}