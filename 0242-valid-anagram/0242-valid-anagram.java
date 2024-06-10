class Solution {
    public boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> checker = new HashMap<>();
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if (checker.containsKey(s1.charAt(i))){
                checker.put(s1.charAt(i),checker.get(s1.charAt(i))+1);
            }else {
                checker.put(s1.charAt(i),1);
            }
        }
        for(int i=0;i<s1.length();i++){
            if(checker.containsKey(s2.charAt(i))){
                checker.put(s2.charAt(i),checker.get(s2.charAt(i))-1);
            } else {
                checker.put(s2.charAt(i),1);
            }
        }
        for (Character key : checker.keySet()) {
            if(checker.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}