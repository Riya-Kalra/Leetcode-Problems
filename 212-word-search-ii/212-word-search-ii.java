class Solution {
    
    HashSet <String> ans= new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        //We are gonna check all the words simultaneously with the help of trie
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
            
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                exist(board, "", i, j, visited, trie);
            }
        }
        return new ArrayList<String>(ans);
    }
    
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    
    void exist (char[][] b, String s,int i,int j, int vis[][], Trie trie){
        
        if(i<0 || i>=b.length || j<0 || j>=b[0].length || vis[i][j]==1) return ;
        s += b[i][j];
        
        if (!trie.startsWith(s)) 
            return;
        //System.out.println(s +" "+ trie.search(s));
        if (trie.search(s) ) {
            ans.add(s);
        }
       // System.out.println(ans);
            vis[i][j]=1;
            for(int i1=0;i1<4;i1++){
                int xx=i+dx[i1];
                int yy=j+dy[i1];
               exist(b, s, xx, yy, vis, trie);
            }
             vis[i][j]=0; 
    }
    
    class Node{
       Node link[];
        boolean flag;
        String item;
        public Node(){
            link=new Node[26];
            flag=false;
            item="";
            
        } 
    }
    class Trie{
         Node root=new Node();
        public void insert(String word){
            Node node = root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.link[ch - 'a'] == null) {
                node.link[ch - 'a'] = new Node();
            }
            node = node.link[ch - 'a'];
            }
            node.flag=true;
            //node.item = word;
        }
        
        public boolean search(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                if (node.link[c - 'a'] == null) 
                    return false;
                node = node.link[c - 'a'];
            }
            return node.flag;
            //return node.item.equals(word);
        }
        public boolean startsWith(String prefix) {
            Node node = root;
            for (char c : prefix.toCharArray()) {
                if (node.link[c - 'a'] == null)
                    return false;
                node = node.link[c - 'a'];
            }
            return true;
        }
    }
}