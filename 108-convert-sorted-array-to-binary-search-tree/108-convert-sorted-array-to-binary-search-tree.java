/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         th is.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //if(nums.length==0) return null;
        return bs(nums,0,nums.length-1);
    }
    public TreeNode bs(int nums[], int s, int e){
        if(s>e)return null;
        int mid=s+(e-s)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=bs(nums,s,mid-1);
        root.right=bs(nums,mid+1,e);
        return root;
       
        
    }
}