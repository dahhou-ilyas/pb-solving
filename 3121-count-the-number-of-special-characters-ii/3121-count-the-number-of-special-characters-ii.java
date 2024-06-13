class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (final char c : word.toCharArray())
          if (Character.isLowerCase(c))
            lower[c - 'a'] = !upper[c - 'a'];
          else
            upper[c - 'A'] = true;

        for (int i = 0; i < 26; ++i)
          if (lower[i] && upper[i])
            ++count;

        return count;
    }
}