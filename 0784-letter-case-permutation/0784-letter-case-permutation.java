class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> resutl=new ArrayList<>();
        List<Character> sub=new ArrayList<>();
        backtraking(s,0,sub,resutl);
        return resutl;
    }

    private void backtraking(String s,int index,List<Character> sub,List<String> result){
        if (index == s.length()) {
            String subresult = sub.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining());
            result.add(subresult);
            return;
        }
        char currentChar = s.charAt(index);


        if(Character.isDigit(currentChar)){
            sub.add(currentChar);
            backtraking(s, index + 1, sub, result);
            sub.remove(sub.size() - 1);
        }else{
            sub.add(Character.toLowerCase(currentChar));
            backtraking(s, index + 1, sub, result);
            sub.remove(sub.size() - 1);

            sub.add(Character.toUpperCase(currentChar));
            backtraking(s, index + 1, sub, result);
            sub.remove(sub.size() - 1);
        }
    }
}