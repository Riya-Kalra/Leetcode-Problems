class Node 
     {
         Node prev,next;
         int key,value;
         Node (int k, int v)
         {
             key=k;value=v;prev=null;next=null;
         }
     }

class LRUCache {
    
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node> map=new HashMap();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node t=map.get(key);
            remove(t);
            insert(t);
            return (t.value);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        remove(map.get(key));
        if(map.size()==capacity)
        remove(tail.prev);//if reached the capacity remove the last recently used guy that is just before prev
        insert(new Node(key,value));
    }
    public void remove(Node t){
        map.remove(t.key);
        Node next=t.next;
        Node prev=t.prev;
        next.prev=t.prev;
        prev.next=t.next;
        
    }
    public void insert(Node t){
        map.put(t.key,t);
        Node headnext=head.next;
        head.next=t;
        t.next=headnext;
        headnext.prev=t;
        t.prev=head;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */