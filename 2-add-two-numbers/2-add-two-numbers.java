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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int no=0,c=0;
        ListNode ans =new ListNode(0);
        ListNode ptr=ans;
       while(l1!=null || l2!=null){
           no=c;
           if (l1!=null){
               no+=l1.val;
               l1=l1.next;
            }
           if(l2!=null) {
               no+=l2.val;
               l2=l2.next;
           }
           c=no/10;
           no=no%10;
           ans.next=new ListNode(no);
           ans=ans.next;
       } 
        if(c!=0){
            ans.next=new ListNode(c);
            ans=ans.next;
        }
        ans.next=null;
        return(ptr.next);
        
    }
    public ListNode reverse(ListNode curr){
        ListNode next=null,prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}