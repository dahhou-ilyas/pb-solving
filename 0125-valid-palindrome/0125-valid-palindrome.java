class Solution {
    public boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int r=cleanString.length()-1;
        int l=0;
        while (l<r){
            if(cleanString.charAt(l)!=cleanString.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}