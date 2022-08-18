class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> stk =new Stack<>();
        int n=nums2.length;
        HashMap <Integer,Integer> map =new HashMap<>();
        for(int i=n-1 ;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums2[i])
                stk.pop();
            if(stk.isEmpty())
                map.put(nums2[i],-1);
            else
                map.put(nums2[i],stk.peek());
            stk.add(nums2[i]);
        }
        //System.out.println(map);
        int ans[] = new int[nums1.length];
        for(int i=nums1.length-1 ;i>=0;i--){
            ans[i]=map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}