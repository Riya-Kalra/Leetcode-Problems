class Solution {
    public int evalRPN(String[] t) {
        Stack<Integer> stk =new Stack<>();
        for(int i=0;i<t.length;i++){
                
                if(t[i].equals("*")){
                    int a=stk.pop();
                    int b=stk.pop();
                    stk.push(a*b);
                }
                else if(t[i].equals("/")){
                    int a=stk.pop();
                    int b=stk.pop();
                    stk.push(b/a);
                }
                else if(t[i].equals("-")){
                    int a=stk.pop();
                    int b=stk.pop();
                    stk.push(b-a);
                }
                else if(t[i].equals("+")){
                    int a=stk.pop();
                    int b=stk.pop();
                    stk.push(a+b);
                }
                else
                stk.push(Integer.parseInt(t[i]));
            
        }
        return stk.pop();
    }
}