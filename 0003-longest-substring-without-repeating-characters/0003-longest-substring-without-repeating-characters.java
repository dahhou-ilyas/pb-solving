class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max_len=0;
        int l=0;
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(i));
            max_len=Math.max(max_len,i-l+1);
        }
        return max_len;
    }
}