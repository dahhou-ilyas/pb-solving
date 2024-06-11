class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] nbrJours=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){
                int index=stk.pop();
                nbrJours[index]=i-index;
            }
            stk.push(i);
        }
        return nbrJours;
    }
}