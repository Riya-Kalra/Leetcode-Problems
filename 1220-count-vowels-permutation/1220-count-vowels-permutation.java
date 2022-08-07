class Solution {
    char ch[]={'a','e','i','o','u'};
    long count=0l;
    int mod=1000000007;
   HashMap<String,Long> map =new HashMap<>();
    public int countVowelPermutation(int n) {
        if(n==1) return 5;
        for(char c:ch){
            count+=dfs(c,n - 1)%mod;
        }
        //System.out.println(map.toString());
        return (int)(count%1000000007);
    }
    public long dfs(char c, int n){
        if(n==0){
            return 1L;
        }
        if(map.containsKey(c+" "+n))
            return map.get(c+" "+n);
        long ans=0L,result=0L;
            if(c=='a')
                ans=dfs('e',n-1);
            else if (c=='e' )
                ans=dfs('a',n-1)+dfs('i',n-1);
            else if(c=='i')
                ans=dfs('e',n-1)+dfs('a',n-1)+dfs('o',n-1)+dfs('u',n-1);
            else if(c=='o' )
                ans=dfs('u',n-1)+dfs('i',n-1);
            else if(c=='u')
                ans=dfs('a',n-1);
        map.put(c+" "+n,ans%mod);
        //System.out.println(ans + " " + c + " " + n);
        return ans%mod;
    }
}