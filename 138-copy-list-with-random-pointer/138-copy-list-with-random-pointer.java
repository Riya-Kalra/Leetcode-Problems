/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node next=null,curr=head;
        if(head==null) return null;
        //copying node
        while(curr!=null){
            next=curr.next;
            Node copy = new Node(curr.val);
            curr.next= copy;
            copy.next=next;
            curr=copy.next;
        }
        next=null;curr=head;
        while(curr!=null){
            next=curr.next;
            if(curr.random!=null)
            next.random=(curr.random).next;
            curr=curr.next.next;
        }
        Node h=head, h2=head.next ,head2=h2;
        while(h!=null ){
            h.next=h.next.next;
            if(h.next!=null)
            h2.next=h2.next.next;
            h=h.next;
            h2=h2.next;
        }
        
        return head2;
    }
}