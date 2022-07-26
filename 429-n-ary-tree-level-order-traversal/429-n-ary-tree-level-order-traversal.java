/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=  new ArrayList<List<Integer>>();
        Queue <Node> q= new LinkedList<>();
        if(root ==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> a=  new ArrayList <Integer>();
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Node t=q.poll();
                a.add(t.val);
                for (Node c:t.children){
                    if(c!=null)
                    q.add(c);
                }
            }
            //System.out.println(a.toString());
            ans.add(new ArrayList<Integer>(a));
        }
        return ans;
    }
}