class TreeNode{
    Map<Character,TreeNode> childes;
    boolean word;
    public TreeNode(){
        this.childes=new HashMap<>();
        this.word=false;

    }
}

class WordDictionary {

    TreeNode root;
    public WordDictionary() {
        this.root=new TreeNode();
    }
    
    public void addWord(String word) {
        TreeNode curr=this.root;
        for(int i=0;i<word.length();i++){
            if(!curr.childes.containsKey(word.charAt(i))){
                curr.childes.put(word.charAt(i),new TreeNode());
            }
            curr=curr.childes.get(word.charAt(i));
        }
        curr.word=true;
    }
    
    public boolean search(String word) {
        TreeNode curr=this.root;
        return helper(word,0,curr);
    }
    
    private boolean helper(String word, int index, TreeNode curr) {
    if (index >= word.length()) {
        return curr.word;  // curr.word doit être un booléen indiquant si ce noeud marque la fin d'un mot
    }
    
    char c = word.charAt(index);
    if (c != '.') {
        if (!curr.childes.containsKey(c)) {
            return false;
        }
        return helper(word, index + 1, curr.childes.get(c));
    } else {
        for (Character key : curr.childes.keySet()) {
            if (helper(word, index + 1, curr.childes.get(key))) {
                return true;
            }
        }
        return false;
    }
}


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */