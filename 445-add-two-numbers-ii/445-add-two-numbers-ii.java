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
       Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode curr = new ListNode(0);
        ListNode ptr=curr;
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) 
                sum += s1.pop();
            if (!s2.empty()) 
                sum += s2.pop();
            
            curr.next= new ListNode(sum % 10);
            curr=curr.next;
            sum /= 10;
        }
        if(sum!=0)
           curr.next= new ListNode(sum); 
        return reverse(ptr.next);
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