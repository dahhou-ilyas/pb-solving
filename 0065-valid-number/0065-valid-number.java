class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        
        boolean seenNum = false;
        boolean seenDot = false;
        boolean seenE = false;
        
        s = s.trim();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenNum = true;
            } else if (c == '.') {
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenNum) {
                    return false;
                }
                seenE = true;
                seenNum = false; // Reset seenNum for the exponent part
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false; // Invalid character
            }
        }
        
        return seenNum;
    }
}