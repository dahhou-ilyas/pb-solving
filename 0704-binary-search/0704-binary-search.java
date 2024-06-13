class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int median=(low+high)/2;
            if(nums[median]==target){
                return median;
            }else if(nums[median]<target){
                low=median+1;
            }else {

                high=median-1;
            }
        }
        return -1;
    }
}