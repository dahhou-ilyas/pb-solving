class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int low = 1;
        int high = max;
        int nbrDeK = max;

        while (low <= high){
            int median=(low+high)/2;
            int nbrHour=0;

            for(int i=0;i<piles.length;i++){
                nbrHour = (int) (nbrHour+ Math.ceil((double) piles[i] / median));

            }
            if(nbrHour <= h){
                nbrDeK =median;
                high = median - 1 ;

            }else {
                low = median + 1;
            }
        }
        return nbrDeK;
    }
}