class Solution {
    public List<String> letterCombinations(String digits) {
        String arr[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> ans=new ArrayList<String>();
        
        if(digits.length() == 0) return ans;
        String s  = "";
        permute(0,s,digits,ans,arr);
        return ans;
    }
    void permute(int idx,String s,String digits,ArrayList<String> ans,String arr[]){
        if(idx==digits.length()){
            ans.add(s);
            return;
        }
        int digit=digits.charAt(idx)-'0';
        for (int i=0;i<arr[digit-2].length();i++){
            permute(idx+1,s+arr[digit-2].charAt(i),digits,ans,arr);
        }
    }
}