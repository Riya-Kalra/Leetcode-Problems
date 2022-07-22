class Solution {
    public List<Integer> addToArrayForm(int[] A, int k) {
        int carry=k;
        List<Integer>  ans=new ArrayList<Integer> ();
       for (int i = A.length - 1; i >= 0; --i) {
            ans.add(0, (A[i] + carry) % 10);
            carry= (A[i] + carry) / 10;
        }
        while (carry > 0) {
            ans.add(0, carry % 10);
            carry /= 10;
        }
        
        return ans;
    }
}