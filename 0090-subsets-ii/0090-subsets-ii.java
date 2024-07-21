class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currSet=new ArrayList<>();
        backtraking(0,nums,currSet,result);
        return result;
    }

    private void backtraking(int i,int[] nums,List<Integer> currSet,List<List<Integer>> result){
        if(i>=nums.length){
            result.add(new ArrayList<>(currSet));
            return;
        }
        currSet.add(nums[i]);
        backtraking(i+1,nums,currSet,result);
        currSet.remove(currSet.size()-1);

        while(i+1 < nums.length && nums[i]==nums[i+1]){
            i++;
        }
        backtraking(i+1,nums,currSet,result);
    }
}