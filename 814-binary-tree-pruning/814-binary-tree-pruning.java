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
    public TreeNode pruneTree(TreeNode root) {
     if(traverse(root)==false)
         return null;
        return root;
    }
    public boolean traverse(TreeNode curr){
        if(curr==null)
            return false;
        boolean l=traverse(curr.left);
        boolean r=traverse(curr.right);
        if(l==false)
            curr.left=null;
        if(r==false)
            curr.right=null;
        
            return (curr.val==1 || l||r);
        
    }
}