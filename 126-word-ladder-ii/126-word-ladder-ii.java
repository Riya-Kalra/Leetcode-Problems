class Solution {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> adj = new HashMap<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();
        
        for(String a : wordList){
            set.add(a);
        } 
        
        bfs(beginWord, endWord, set);
        
        List<String> current = new ArrayList<>();
        current.add(endWord);
        backtrack(endWord, beginWord, current);
        
        return result;
    }
    
    public void bfs(String beginWord, String endWord, Set<String> set){
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        
        HashSet<String> isEnqueued = new HashSet<>();
        isEnqueued.add(beginWord);
        
        while(queue.size() > 0){
            
            List<String> visited = new ArrayList<>();
            
            for(int i = queue.size() - 1; i >= 0; i--){
                
                String currentWord = queue.poll();
                List<String> neighbours = transformed(currentWord, set);
                
                for(String word : neighbours){
                    
                    visited.add(word);
                    
                    if(!adj.containsKey(word)){
                        adj.put(word, new ArrayList<>());
                    }
                    
                    adj.get(word).add(currentWord);
                    
                    if(!isEnqueued.contains(word)){
                        isEnqueued.add(word);
                        queue.add(word);
                    }
                }
            }
            
            for(int i = 0; i < visited.size(); i++){
                
                if(set.contains(visited.get(i))){
                    set.remove(visited.get(i));
                }
            }
        }
    }
    public void backtrack(String word, String endWord, List<String> list){
        //System.out.println(word);
        if(word.equals(endWord)){
            List<String> temp = new ArrayList<>(list);
            Collections.reverse(temp);
            result.add(new ArrayList<>(temp));
        }
        if(!adj.containsKey(word)){
            return;
        }
        for(String s : adj.get(word)){
            list.add(s);
            backtrack(s, endWord, list);
            list.remove(list.size() - 1);
        }
    }
    public List<String> transformed(String s, Set<String> set){
        List<String> list = new ArrayList<>();
        char word[] = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char old = word[i];
            for(char c = 'a'; c <= 'z'; c++){
                word[i] = c;
                if(c != old && set.contains(String.valueOf(word))){
                    list.add(String.valueOf(word));
                }
            }
            word[i] = old;
        }
        return list;
    }
}