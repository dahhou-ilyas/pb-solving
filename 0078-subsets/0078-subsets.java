class Solution {
    List<List<Integer>> ressult=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset=new ArrayList<>();
        backtrack(nums,0,subset);
        return ressult;

    }
    public void backtrack(int[] nums,int curentIndex,List sub){
        if(curentIndex >= nums.length){
            ressult.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[curentIndex]);
        backtrack(nums,curentIndex+1,sub);
        sub.remove(sub.size()-1);
        backtrack(nums,curentIndex+1,sub);
    }
}