class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0; // According to convention, if needle is empty, return 0
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // If needle is longer than haystack, it cannot be found
        if (needleLength > haystackLength) {
            return -1;
        }

        // Brute force search
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j;
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needleLength) {
                return i; // Found the needle at index i
            }
        }

        return -1;
    }
}