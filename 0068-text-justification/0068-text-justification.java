class Solution {
     public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = 0; // Index of the first word in the current line
        int right = 0; // Index of the last word in the current line

        while (left < words.length) {
            int lineLength = words[left].length(); // Length of the current line
            right = left + 1;

            // Find the rightmost word that can fit in the current line
            while (right < words.length && lineLength + words[right].length() + 1 <= maxWidth) {
                lineLength += words[right].length() + 1; // Add 1 for space between words
                right++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = right - left; // Number of words in the current line
            int numSpaces = maxWidth - lineLength + numWords - 1; // Total spaces to distribute

            // If it's the last line or only one word in the line, left-justify
            if (right == words.length || numWords == 1) {
                for (int i = left; i < right; i++) {
                    line.append(words[i]);
                    if (i < right - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" "); // Pad remaining spaces
            } else {
                int spacesPerWord = numSpaces / (numWords - 1); // Minimum spaces between words
                int extraSpaces = numSpaces % (numWords - 1); // Extra spaces to distribute

                for (int i = left; i < right; i++) {
                    line.append(words[i]);
                    if (i < right - 1) {
                        // Append minimum spaces between words
                        for (int j = 0; j < spacesPerWord; j++) line.append(" ");
                        // Append extra spaces evenly until they are used up
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(line.toString());
            left = right; // Move to the next line
        }

        return result;
}}