class MyCircularQueue {
    int a[];
    int n;
    int head=0,tail=0;
    public MyCircularQueue(int k) {
        n=k;
        a=new int[n];
        Arrays.fill(a,-1);
    }
    
    public boolean enQueue(int value) {
        
        if(a[tail]!=-1)
            return false;
        a[tail]=value;
        tail++;
        if(tail==n)
            tail=0;
        return true;
    }
    
    public boolean deQueue() {
        if(a[head]==-1)
            return false;
        a[head]=-1;
        head++;
        if(head==n)
            head=0;
        return true;
    }
    
    public int Front() {
        return a[head];
    }
    
    public int Rear() {
        if(tail-1<0)
            return a[n-1];
        return a[tail-1];
    }
    
    public boolean isEmpty() {
        if(head==tail && a[tail]==-1 )
            return true;
        else 
            return false;
    }
    
    public boolean isFull() {
        if(tail==head && a[tail]!=-1 )
            return true;
        if(head==0 && tail==n-1)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */