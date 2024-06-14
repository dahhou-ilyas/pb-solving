class Solution {
    public void nextPermutation(int[] nums) {
        int left=nums.length-2;
        while (left >= 0 && nums[left] >= nums[left + 1]){
            left--;
        }
        if (left >= 0){
            int j=nums.length-1;
            while (nums[j]<=nums[left]){
                j--;
            }
            swap(nums,left,j);
        }
        reverse(nums, left + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}