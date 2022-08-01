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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer> ();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null)
            return ans;
        q.add(root);
        while(!q.isEmpty()){
           int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode t =q.poll();
                if(i==sz-1)
                    ans.add(t.val);
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
        }
        return ans;
    }
}