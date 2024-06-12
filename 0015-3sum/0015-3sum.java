class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> resuLists=new ArrayList<>();
        for (int i =0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right =nums.length-1;

            while (left < right){
                int sum =nums[i] + nums[left] +nums [right];

                if(sum==0){
                    resuLists.add(Arrays.asList(nums[i] , nums[left] ,nums [right]));
                    left++;
                    right--;
                    while (nums[left]==nums[left-1] && left<right){
                        left++;
                    }
                    
                } else if (sum<0) {
                    left++;
                }else {
                    right--;
                }
            }
        }

        return resuLists;
    }
}