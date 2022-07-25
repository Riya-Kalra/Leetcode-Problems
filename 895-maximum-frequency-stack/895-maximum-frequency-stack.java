class FreqStack {
    HashMap<Integer,Integer> map;
    PriorityQueue<int[]> pq;
    int index=0;
    public FreqStack() {
        map= new HashMap<>();
        pq=new PriorityQueue<>((a,b)->(b[1]!=a[1]?b[1]-a[1]: b[2]-a[2] ));
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        int a[]= {val,map.get(val),index};
        index++;
        pq.add(a);
    }
    
    public int pop() {
        int a[]=pq.poll();
        map.put(a[0],map.get(a[0])-1);
        if(map.get(a[0])<=0)
            map.remove(a[0]);
        return a[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */