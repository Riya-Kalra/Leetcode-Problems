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
class Pair {
    TreeNode node;
    int dep;
    
    Pair(TreeNode node, int d){
        this.node = node;
        dep = d;
    }
        
}
class Solution {
    public TreeNode recoverFromPreorder(String s) {
       Stack<Pair> st = new Stack<>();
        TreeNode res = null;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '-'){
                count++;
            }
            else{
                int start = i;
                while(i < s.length() && s.charAt(i) != '-') i++;
                
                String str = s.substring(start,i);
                i--;
                int val = Integer.parseInt(str);
                TreeNode temp = new TreeNode(val);
                if(count == 0) res = temp;                
                Pair p = new Pair(temp,count);
                
                
                while(!st.isEmpty() && count <= st.peek().dep){
                    st.pop();   
                }             
                if(!st.isEmpty() && st.peek().node.left == null){
                    st.peek().node.left = temp;
                }
                else if(!st.isEmpty()){
                    st.peek().node.right = temp;
                }
                count = 0;
                 st.push(p); 
                
            }
        }

       return res;
    }
}