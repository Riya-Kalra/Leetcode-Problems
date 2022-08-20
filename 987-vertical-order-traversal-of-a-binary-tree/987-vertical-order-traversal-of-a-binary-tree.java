/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    int vert, level;
    TreeNode node;
    Pair(TreeNode t,int v,int l){
        node=t;
        vert=v;
        level=l;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       Queue<Pair> q =new LinkedList<>();
        TreeMap<Integer, PriorityQueue<Pair>> map= new TreeMap<>();
        List<List<Integer>>  ans= new ArrayList<List<Integer>> ();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(!map.containsKey(p.vert))
                map.put(p.vert,new PriorityQueue<Pair>((a,b)->(b.level!=a.level )? a.level-b.level: a.node.val-b.node.val) );
            PriorityQueue<Pair> arr= map.get(p.vert);
            arr.add(p);
            if(p.node.left!=null)
                q.add(new Pair(p.node.left,p.vert-1,p.level+1));
            if(p.node.right!=null)
                q.add(new Pair(p.node.right,p.vert+1,p.level+1));
            
        }
        for(Integer k: map.keySet()){
             PriorityQueue<Pair> p=map.get(k);
            ArrayList<Integer> a =new ArrayList<>();
            while(!p.isEmpty())
                a.add(p.poll().node.val);
            ans.add(new ArrayList<Integer>(a));
        }
        return ans;
    }
}