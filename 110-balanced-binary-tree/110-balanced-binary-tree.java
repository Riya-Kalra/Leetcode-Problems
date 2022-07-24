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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int l= height(root.left);
        int r=height(root.right);
        if(l<0 || r<0)
            return false;
        if(Math.abs(l-r)<=1)
            return true;
        else
            return false;
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int l= height(root.left);
        int r=height(root.right);
        if(Math.abs(l-r)<=1)
            return (1+ Math.max(l,r));
        else
            return -10000;
        
    }
}