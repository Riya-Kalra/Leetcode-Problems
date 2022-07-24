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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode root) {
        if(root==null) return 0;
        int l=depth(root.left);
        int r=depth(root.right);
        int h= 1+Math.max(l,r);
        ans=Math.max(ans,l+r);
        return h;
    }
}