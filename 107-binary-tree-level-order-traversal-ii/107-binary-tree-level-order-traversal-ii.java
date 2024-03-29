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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<> ();
         if(root==null)
             return ans;
        
        Queue <TreeNode> q =new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int sz= q.size();
            ArrayList <Integer> temp =new ArrayList<>();
            
            for (int i=0; i< sz; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                
                if(node.left!=null)
                    q.add(node.left);
                if (node.right!=null)
                    q.add(node.right);
            }
            //System.out.println(temp);
            ans.add(0,new ArrayList<>(temp));
        }
        return ans;
    }
}