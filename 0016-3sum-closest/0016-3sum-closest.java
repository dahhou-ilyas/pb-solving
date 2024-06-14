class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closet=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i =0 ; i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(closet - target))
                    closet = sum;
                if (sum < target) l++;
                else r--;
            }
        }
        return closet;
    }
}