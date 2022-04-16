class Trie {
    static Trie root;
    Trie arr[] = new Trie[26];
    boolean isEnd = false;
    public Trie() {
    }
    public void insert(String word) {
        int length = word.length();
        Trie currentNode = this;
        for(int i=0;i<length;i++) {
            char c = word.charAt(i);
            int ind = (int)c - 97;
            if(currentNode.arr[ind] == null) {
                currentNode.arr[ind] = new Trie();
            }
            currentNode = currentNode.arr[ind];
        }
        currentNode.isEnd = true;
    }
    public boolean search(String word) {
        int length = word.length();
        Trie currentNode = this;
        for(int i=0;i<length;i++) {
            char c = word.charAt(i);
            int ind = (int)c - 97;
            if(currentNode.arr[ind] != null) {
                currentNode = currentNode.arr[ind];
            }
            else
                return false;
        }
       return currentNode.isEnd;
           
    }
    
    public boolean startsWith(String prefix) {
       int length = prefix.length();
        Trie currentNode = this;
        for(int i=0;i<length;i++) {
            char c = prefix.charAt(i);
            int ind = (int)c - 97;
            if(currentNode.arr[ind] != null) {
                currentNode = currentNode.arr[ind];
            }
            else
                return false;
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