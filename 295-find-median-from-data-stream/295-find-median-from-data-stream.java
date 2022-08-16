class MedianFinder {
    
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left= new PriorityQueue <>((a,b)->(b-a));
        right= new PriorityQueue <>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || left.peek()>num)
            left.add(num);
        else
            right.add( num);
        if(left.size()> right.size()+1)
            right.add(left.poll());
        else if (left.size()<right.size())
            left.add(right.poll());
    }
    
    public double findMedian() {
        if (left.size()==right.size())
            return (left.peek()+right.peek())/2.0;
        else
            return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */