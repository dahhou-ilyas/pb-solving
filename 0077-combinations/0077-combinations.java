class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        backtraking(1,sub,result,n,k);
        return result;
    }
    private void backtraking(int i,List<Integer> sub,List<List<Integer>> result,int n, int k){
        if(sub.size()==k){
            result.add(new ArrayList(sub));
            return;
        }
        if(i>n){
            return;
        }

        for(int j=i;j<=n;j++){
            sub.add(j);
            backtraking(j+1,sub,result,n,k);
            sub.remove(sub.size()-1);
        }
    }
}