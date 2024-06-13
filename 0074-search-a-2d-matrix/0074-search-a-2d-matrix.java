class Solution {
    public boolean search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int median=(low+high)/2;
            if(nums[median]==target){
                return true;
            }else if(nums[median]<target){
                low=median+1;
            }else {
                high=median-1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(search(matrix[i],target)){
                return true;
            }
        }
        return false;
    }
}