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
    int diff=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        traverse(root);
        return diff;
        
    }
    public int[] traverse (TreeNode root){
        if(root==null)
            return new int []{Integer.MAX_VALUE,Integer.MIN_VALUE};
        int l[]=traverse(root.left);
        int r[]=traverse(root.right);
        int ans[]= new int[2];
        ans[0]=Math.min(l[0],r[0]);
        ans[1]=Math.max(l[1],r[1]);
        if(ans[0]!=Integer.MAX_VALUE)
            diff=Math.max(diff,Math.abs(root.val-ans[0]));
        if(ans[1]!=Integer.MIN_VALUE)
             diff=Math.max(diff,Math.abs(root.val-ans[1]));
        ans[0]=Math.min(ans[0],root.val);
        ans[1]=Math.max(ans[1],root.val);
        return ans;
    }
}