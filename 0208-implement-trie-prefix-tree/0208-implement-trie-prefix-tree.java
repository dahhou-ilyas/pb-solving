class TreeNode{
     Map<Character,TreeNode> childrent;
     boolean word;
    
    public TreeNode(){
        this.childrent = new HashMap<>();
        this.word=false;
    }

}

class Trie {
    private TreeNode root;

    public Trie() {
        this.root=new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode curr=this.root;
        for (int i = 0; i < word.length(); i++) {
            if(!curr.childrent.containsKey(word.charAt(i))){
                curr.childrent.put(word.charAt(i),new TreeNode());
            }
            curr=curr.childrent.get(word.charAt(i));
        }
        curr.word=true;

    }
    
    public boolean search(String word) {
        TreeNode curr=this.root;
        for (int i = 0; i < word.length(); i++) {
            if(!curr.childrent.containsKey(word.charAt(i))){
                return false;
            }
            curr=curr.childrent.get(word.charAt(i));
        }
        return curr.word;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode curr=this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!curr.childrent.containsKey(prefix.charAt(i))){
                return false;
            }
            curr=curr.childrent.get(prefix.charAt(i));
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