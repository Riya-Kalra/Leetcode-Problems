class Node{
    Node link[]=new Node[26];
    boolean flag=false;
    boolean containsKey(char ch){
         return (link[ch-'a']!=null);
     }
    void put(char ch,Node node){
        link[ch-'a'] =node;
     }
    Node get(char ch){
            return (link[ch-'a']);
        }
    boolean isEnd(){
        return flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        int n=word.length();
        Node node=root;
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                node.put(ch,new Node());
            node=node.get(ch);
            }
            node.flag=true;
    }
    
    public boolean search(String word) {
        int n=word.length();
        Node node=root;
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                return false;
             node=node.get(ch);
        }
        return (node.isEnd());
            
    }
    
    public boolean startsWith(String prefix) {
        int n=prefix.length();
        Node node=root;
        for(int i=0;i<n;i++){
            char ch=prefix.charAt(i);
            if(!node.containsKey(ch))
                return false;
             node=node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */