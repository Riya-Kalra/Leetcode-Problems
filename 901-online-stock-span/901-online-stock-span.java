class Pair{
    int val,idx;
    public  Pair(int val,int idx){
        this.val=val;
        this.idx=idx;
    }
}
class StockSpanner {
    Stack <Pair> stk;
    int i=1;
    public StockSpanner() {
        stk= new Stack<Pair>();
    }
    
    public int next(int price) {
        int ans=-1;
        //Decreasing stack
        while(!stk.isEmpty() && stk.peek().val<=price){
            stk.pop();
        }
        if(stk.isEmpty())
            ans=i;
        else 
            ans=i-stk.peek().idx;
        stk.push(new Pair(price,i));
        i++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */