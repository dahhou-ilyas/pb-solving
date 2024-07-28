class Solution {
    public boolean exist(char[][] board, String word) {
        // Parcourir chaque cellule pour commencer la recherche
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (healper(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean healper(char[][] board, int iligne, int icolo, int index, String word) {
        // Vérifier les conditions de sortie
        if (index == word.length()) {
            return true; // Mot trouvé
        }
        if (iligne < 0 || iligne >= board.length || icolo < 0 || icolo >= board[0].length || board[iligne][icolo] != word.charAt(index)) {
            return false;
        }
        
        // Sauvegarder la cellule et marquer comme visitée
        char temp = board[iligne][icolo];
        board[iligne][icolo] = '#'; // Marquer comme visité

        // Explorer les 4 directions adjacentes
        boolean found = healper(board, iligne + 1, icolo, index + 1, word) ||
                        healper(board, iligne - 1, icolo, index + 1, word) ||
                        healper(board, iligne, icolo + 1, index + 1, word) ||
                        healper(board, iligne, icolo - 1, index + 1, word);

        // Restaurer la cellule originale
        board[iligne][icolo] = temp;

        return found;
    }
}
