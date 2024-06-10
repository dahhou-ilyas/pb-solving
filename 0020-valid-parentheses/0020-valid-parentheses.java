class Solution {
    public boolean isValid(String s) {
        List<Character> stack=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.add(s.charAt(i));
            }
            if(stack.size()==0){
                return false;
            }
            if( s.charAt(i)==')' ){
                if(stack.get(stack.size()-1) == '('){
                    stack.remove(stack.size()-1);
                }else {
                    return false;
                }

            } else if (s.charAt(i)=='}') {
                if (stack.get(stack.size()-1) =='{'){
                    stack.remove(stack.size()-1);
                }else {
                    return false;
                }

            } else if (s.charAt(i)==']' ) {
                if (stack.get(stack.size()-1) =='['){
                    stack.remove(stack.size()-1);
                }
                else{
                    return false;
                }
            }
        }

        return stack.size() ==0;
    }
}