class Solution {
    public List<String> result=new ArrayList();
    public List<String> validStrings(int k) {
        char[] ch = new char[k];
        ch[0] = '0';
        generate(k, ch, 1);
        ch[0] = '1';
        generate(k, ch, 1);
        return result;
    }
    void generate(int k, char[] ch, int n){
        if (n == k) {
            result.add(new String(ch));
            return;
        }
        if (ch[n - 1] == '0') {
            ch[n] = '1';
            generate(k, ch, n + 1);
        }
        if (ch[n - 1] == '1') {
            ch[n] = '0';
            generate(k, ch, n + 1);
            ch[n] = '1';
            generate(k, ch, n + 1);
 
        }
    }
}