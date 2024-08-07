class Solution {
    public int candy(int[] ratings) {
        int[] candyv1=new int[ratings.length];
        int[] candyv2 =new int[ratings.length];
        candyv1[0]=1;
        candyv2[candyv2.length-1]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candyv1[i]=candyv1[i-1]+1;
            }else{
                candyv1[i]=1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candyv2[i]=candyv2[(i+1)]+1;
            }else{
                candyv2[i]=1;
            }
        }
        int sum=0;
        for(int i=0;i<ratings.length;i++){
            sum=sum+Math.max(candyv2[i],candyv1[i]);
        }
        return sum;   
    }
}