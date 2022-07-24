class Trie {
    private Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                node.put(ch,new Node());
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node=root;
         for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                return false;
             node=node.get(ch);
         }
        if(node.isEnd())
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!node.containsKey(ch))
                return false;
             node=node.get(ch);
         }
        return true;
    }
}
class Node{
        Node link[]=new Node[26];
        boolean flag=false;
        boolean containsKey(char ch){
            return (link[ch-'a']!=null);
        }
        boolean isEnd(){
            return flag;
        }
        void setEnd(){
            flag=true;
        }
        Node get(char ch){
            return (link[ch-'a']);
        }
        void put(char ch,Node node){
            link[ch-'a']=node;
        }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */