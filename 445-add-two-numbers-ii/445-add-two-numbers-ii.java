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
        
        int sum = 0,count=0;
        ListNode head=null,curr = null;
        ListNode ptr=curr;
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) 
                sum += s1.pop();
            if (!s2.empty()) 
                sum += s2.pop();
            head= new ListNode(sum % 10);
            if(count!=0)
            head.next=curr;
            curr=head;
            sum /= 10;
            count++;
        }
        if(sum!=0){
           head= new ListNode(sum % 10);
            head.next=curr;
        }
        return head;
    }
    
}