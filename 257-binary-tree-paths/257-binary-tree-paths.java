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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans= new ArrayList<String> ();
        if(root==null)
            return (ans);
        String s=Integer.toString(root.val);
        if(root.left==null && root.right==null)
            ans.add(s);
        if(root.left!=null)
        dfs(root.left,s,ans);
        if(root.right!=null)
        dfs(root.right,s,ans);
        
        return (ans);
    }
    public void dfs(TreeNode root, String s,List <String> ans){
        if(root.left==null && root.right==null){
            s+="->"+Integer.toString(root.val);
            ans.add(s);
            return ;
        }
        s+="->"+Integer.toString(root.val);
        if(root.left!=null)
        dfs(root.left,s,ans);
        if(root.right!=null)
        dfs(root.right,s,ans);
    }
}