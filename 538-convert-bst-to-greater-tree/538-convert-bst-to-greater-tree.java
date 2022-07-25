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
    public TreeNode convertBST(TreeNode root) {
        solve(root);
       return root; 
    }
    int sum=0;
    public void solve(TreeNode root){
        if (root==null)
            return;
        if(root.right!=null)
        solve(root.right);
        sum+=root.val;
        root.val=sum;
        if(root.left!=null)
        solve(root.left);
        return ;
    }
}