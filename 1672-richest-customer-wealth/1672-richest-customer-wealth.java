class Solution {
    public int maximumWealth(int[][] accounts) {
        int total=0;
        for(int i=0;i<accounts.length;i++){
            int max=0;
            for(int j=0;j<accounts[i].length;j++){
                max=max+accounts[i][j];
            }
            if(max>total){
                total=max;
            }
        }
        return total;
    }
}