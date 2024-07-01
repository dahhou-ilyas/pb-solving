class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> hashmap=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int hashKey=nums[i]%nums.length;
            if(hashmap.containsKey(hashKey)){
                return nums[i];
            }
            hashmap.put(hashKey,nums[i]);
        }
        return -1;
    }
}