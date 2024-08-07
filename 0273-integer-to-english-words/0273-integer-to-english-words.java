class Solution {
    
    private static final Map<Integer, String> numberMap = new HashMap<>();
    static {
    numberMap.put(0, "Zero");
    numberMap.put(1, "One");
    numberMap.put(2, "Two");
    numberMap.put(3, "Three");
    numberMap.put(4, "Four");
    numberMap.put(5, "Five");
    numberMap.put(6, "Six");
    numberMap.put(7, "Seven");
    numberMap.put(8, "Eight");
    numberMap.put(9, "Nine");
    //--------------------
    numberMap.put(11, "Eleven");
    numberMap.put(12, "Twelve");
    numberMap.put(13, "Thirteen");
    numberMap.put(14, "Fourteen");
    numberMap.put(15, "Fifteen");
    numberMap.put(16, "Sixteen");
    numberMap.put(17, "Seventeen");
    numberMap.put(18, "Eighteen");
    numberMap.put(19, "Nineteen");
    //---------------------------
    numberMap.put(10, "Ten");
    numberMap.put(20, "Twenty");
    numberMap.put(30, "Thirty");
    numberMap.put(40, "Forty");
    numberMap.put(50, "Fifty");
    numberMap.put(60, "Sixty");
    numberMap.put(70, "Seventy");
    numberMap.put(80, "Eighty");
    numberMap.put(90, "Ninety");

    }
    public String numberToWords(int num) {
        
        if(num ==0 ){
            return numberMap.get(0); 
        }
        StringBuilder words = new StringBuilder();
        if(num / 1_000_000_000 > 0 ){
            words.append(convertThreeDigitGroups(num/1_000_000_000)).append(" Billion ");
            num=num%1_000_000_000;
        }
        if(num / 1_000_000 > 0){
            words.append(convertThreeDigitGroups(num / 1_000_000)).append(" Million ");
            num %= 1_000_000;
        }
        if (num / 1_000 > 0) {
            words.append(convertThreeDigitGroups(num / 1_000)).append(" Thousand ");
            num %= 1_000;
        }
        if (num > 0) {
            words.append(convertThreeDigitGroups(num));
        }
        return words.toString().trim();
        
    }

    private String convertThreeDigitGroups(int number){
        
        StringBuilder words = new StringBuilder();
        if (number / 100 > 0) {
            words.append(numberMap.get(number / 100)).append(" Hundred ");
            number %= 100;
        }
        if (number > 0) {
            if (numberMap.containsKey(number)) {
                words.append(numberMap.get(number));
            } else {
                words.append(numberMap.get((number / 10) * 10)).append(" ");
                words.append(numberMap.get(number % 10));
            }
        }
        return words.toString().trim();
    }
}