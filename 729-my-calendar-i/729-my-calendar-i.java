class Pair{
    int start;
    int end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class Node{
    Pair p;
    Node left;
    Node right;
    public Node(){};
    public Node(Pair p, Node left, Node right){
        this.p = p;
        this.left = left;
        this.right = right;
    }
}

class MyCalendar {
    Node root;
    public MyCalendar() {
      root= new Node();  
    }
    
    public boolean book(int start, int end) {
       return checkAndUpdate(start, end, root); 
    }
    
    public boolean checkAndUpdate(int start, int end, Node root){
        if(root.p == null){
            root.p = new Pair(start, end);
            root.left = new Node();
            root.right = new Node();
            return true;
        }
    
        if(end <= root.p.start){
            return checkAndUpdate(start, end, root.left);
        }
        if(start >= root.p.end){
            return checkAndUpdate(start, end, root.right);
        }
        return false;
}
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */