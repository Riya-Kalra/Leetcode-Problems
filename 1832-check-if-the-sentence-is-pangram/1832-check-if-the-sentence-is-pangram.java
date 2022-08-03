class Solution {
    public boolean checkIfPangram(String s) {
        HashSet<Character> set= new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            set.add(ch);
        }
        if(set.size()==26)
            return true;
        return false;
    }
}