class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        backtraking(0,candidates,target,sub,result,0);
        return result;
    }

    private void backtraking(int i,int[] candidates,int target,List<Integer> sub,List<List<Integer>> result,int accum){
        if(accum>target) {
            return;
        }
        if(accum == target){
            result.add(new ArrayList(sub));
            return ;
        }
        

        for(int j=i;j<candidates.length;j++){
            accum=accum+candidates[j];
            sub.add(candidates[j]);
            backtraking(j,candidates,target,sub,result,accum);
            accum=accum-candidates[j];
            sub.remove(sub.size()-1);
        }

    }
}