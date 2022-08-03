class MinStack {
    Stack<Integer> stk;
    ArrayList<Integer> a;
    public MinStack() {
        stk= new Stack<>();
        a=new ArrayList<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(a.size()==0 || a.get(a.size()-1)>=val){
            a.add(val);
        }
    }
    
    public void pop() {
        int t= stk.pop();
        if(a.size()!=0 && a.get(a.size()-1)==t)
            a.remove(a.size()-1);
    }
    
    public int top() {
        return (stk.peek());
    }
    
    public int getMin() {
        return a.get(a.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */