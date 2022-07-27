class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk =new Stack<>();
        int n=nums.length;
        int a[]=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!stk.isEmpty() && nums[i%n]>=stk.peek()){
                stk.pop();
            }
            if(stk.isEmpty())
                a[i%n]=-1;
            else
            a[i%n]=stk.peek();
            stk.push(nums[i%n]);
        }
        
        return a;
    }
}