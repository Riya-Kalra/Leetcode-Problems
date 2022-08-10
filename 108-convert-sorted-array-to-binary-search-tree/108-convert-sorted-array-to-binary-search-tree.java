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
    public TreeNode sortedArrayToBST(int[] nums) {
         return BS(nums,0,nums.length-1);
    }
    public TreeNode BS (int nums[],int s, int e){
        TreeNode node=null;
        if(s<=e){
            int mid= s+(e-s)/2;
            node= new TreeNode(nums[mid]);
            node.left=BS(nums,s,mid-1);
            node.right=BS(nums,mid+1,e); 
        }
        return node;
    }
}