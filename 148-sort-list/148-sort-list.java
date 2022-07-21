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
    public ListNode sortList(ListNode A) {
       if(A==null || A.next==null)
           return A;
        ListNode temp=A,slow=A,fast= A;
        while(fast!=null && fast.next!=null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next=null;
        ListNode left=sortList(A);
        ListNode right=sortList(slow);
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right) {
        ListNode dummy= new ListNode(0);
        ListNode curr=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                curr.next=left;
                left=left.next;
            }
            else{
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        if(left!=null)
            curr.next=left;
        if(right!=null)
            curr.next=right;
        return dummy.next;
    } 
}