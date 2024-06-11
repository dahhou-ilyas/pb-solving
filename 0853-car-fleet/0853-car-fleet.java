class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stk= new Stack<>();

        double[][] pair = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Double.compare(a[0], b[0]));


        for(int i = position.length-1;i>=0;i--){
            double timeToTarget =(double) (target - pair[i][0]) / pair[i][1];
            if (!stk.isEmpty() && timeToTarget <= stk.peek()) {
                continue;
            }
            stk.push(timeToTarget);
        }
        return stk.size();
    }
}