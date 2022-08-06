class Node{
    int val; Node next, prev;
    public Node(int val){
        this.val=val;
        next=null;
        prev=null;
    }
}
class MyLinkedList {
    Node h,t;int size=0;
    public MyLinkedList() {
        h=new Node(-1);
        t=new Node(-1);
        h.next=t;
        t.prev=h;
    }
    
    public int get(int index) {
        int i=0;
        if(index>=size) return -1;
        Node curr=h.next;
        while(i<index){
          curr=curr.next;
            i++;
        }
        return (curr.val);
    }
    
    public void addAtHead(int val) {
       Node node =new Node(val);
        if(size==0){
            h.next=node;
            node.prev=h;
            node.next=t;
            t.prev=node;
        }else{
            Node head=h.next;
            h.next=node;
            node.prev=h;
            node.next=head;
            head.prev=node;
            head=node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node node =new Node(val);
        Node tail=t.prev;
        tail.next=node;
        node.prev=tail;
        node.next=t;
        t.prev=node;
        tail=node;
        Node temp = h;
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
        Node node =new Node(val);
        if(index>size)
             return;
        if (index == 0) {
            addAtHead(val);
        }
        else{
            int i=0;
            Node curr=h;
            while(i<index){
              curr=curr.next;
                i++;
            }
            Node next2=curr.next;
            curr.next=node;
            node.prev=curr;
            next2.prev=node;
            node.next=next2;
        }
        
        size++;
    }
    
    public void deleteAtIndex(int index) {
        int i=0;
        if(index>=size)
             return;
        if(index==0){
            Node last=h.next.next;
            h.next=last;
            last.prev=h;
            size--;
            return ;
        }
        Node curr=h;
        while(i<index){
          curr=curr.next;
            i++;
        }
        Node n2=curr.next.next;
        curr.next=n2;
        n2.prev=curr;
        Node temp = h;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */