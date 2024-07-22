class Solution {
    Map<Character, List<Character>> phoneMap = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        List<Character> subSet=new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        backtraking(digits,0,subSet,result);
        return result;

    }

    public void backtraking(String digits,int index,List<Character> subSet,List<String> result){
        if(index==digits.length()){
            String subresult = subSet.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining());
            result.add(subresult);
            return ;
        }
        char currentChar = digits.charAt(index);

        for(int i=0;i<phoneMap.get(currentChar).size();i++){
            subSet.add(phoneMap.get(currentChar).get(i));
            backtraking(digits,index+1,subSet,result);
            subSet.remove(subSet.size()-1);
        }
    }
}