class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mediane=(left+right)/2;
            if(nums[mediane]<nums[right]){
                right=mediane;
            }else {
                left=mediane+1;
            }
        }
        return nums[left];
    }
}