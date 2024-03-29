class LRUCache {
    class Node 
     {
         Node prev,next;
         int key,value;
         Node (int k, int v)
         {
             key=k;value=v;prev=null;next=null;
         }
     }

    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node> map=new HashMap();
    int capacity;
    public LRUCache(int cap) {
        capacity=cap;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
           Node t=map.get(key);
            remove(t);//remove it from where ever it is present
            insert(t);// insert it just after head
            return t.value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        remove(map.get(key));
        if(map.size()==capacity)
        remove(tail.prev);//if reached the capacity remove the last recently used guy that is just before prev
        insert(new Node(key,value));
    }
    private void  remove(Node n){
         map.remove(n.key);
         n.prev.next=n.next;
         n.next.prev=n.prev;
     }
     private void insert (Node n){
         map.put(n.key,n);
         Node headnext=head.next;
         head.next=n;
         n.prev=head;
         headnext.prev=n;
         n.next=headnext;
         
     }
}
