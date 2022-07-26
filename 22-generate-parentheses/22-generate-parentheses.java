class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String > a= new ArrayList<>();
        generate(0,0,"",n,a);
        return a;
    }
    public void generate(int open, int close, String s, int n,ArrayList<String > a ){
        if(open==n && close==n){
            a.add(s);
            return;
        }
        if(open==n ){
            generate(open, close+1, s+")",n,a);
        }
        else if(open>close){
            generate(open, close+1, s+")",n,a);
            generate(open+1, close, s+"(",n,a);
        }
        else if(open==close)
            generate(open+1, close, s+"(",n,a);
    }
}