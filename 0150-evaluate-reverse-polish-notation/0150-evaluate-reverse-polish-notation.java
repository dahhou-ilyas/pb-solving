class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk=new Stack<>();
        for(int i =0;i<tokens.length;i++){
            String c= tokens[i];
            switch (c){
                case "+":
                    int ope1=Integer.valueOf(stk.pop());
                    int ope2=Integer.valueOf(stk.pop());
                    stk.push(String.valueOf(ope2+ope1));
                    break;
                case "-":
                    int ope3=Integer.valueOf(stk.pop());
                    int ope4=Integer.valueOf(stk.pop());
                    stk.push(String.valueOf(ope4-ope3));
                    break;
                case "*":
                    int ope5=Integer.valueOf(stk.pop());
                    int ope6=Integer.valueOf(stk.pop());
                    stk.push(String.valueOf(ope5*ope6));
                    break;
                case "/":
                    int ope7=Integer.valueOf(stk.pop());
                    int ope8=Integer.valueOf(stk.pop());
                    int result= (int) Math.floor(ope8/ope7);
                    stk.push(String.valueOf(result));
                    break;
                default:
                    stk.push(tokens[i]);
            }
        }
        return Integer.valueOf(stk.peek());
    }
}