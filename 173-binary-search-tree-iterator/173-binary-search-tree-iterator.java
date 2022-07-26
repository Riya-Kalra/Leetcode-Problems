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
class BSTIterator {
    TreeNode curr;
    Stack <TreeNode> s;
    public BSTIterator(TreeNode root) {
        curr=root;
        s=new Stack();
       
    }
    
    public int next() {
        while(curr!=null){
            s.push(curr);
            curr=curr.left;
        }
        
        curr=s.pop();
        int v=curr.val;
        curr=curr.right;
        return v;
        
       
    }
    
    public boolean hasNext() {
        if(!s.isEmpty()|| curr!=null)
            return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */