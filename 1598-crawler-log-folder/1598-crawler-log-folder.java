class Solution {
    public int minOperations(String[] logs) {
        int mainF=0;
        for(int i=0;i<logs.length;i++){

            if(logs[i].equals("../")){
                if (mainF > 0) {
                    mainF--;
                }
            }else if(logs[i].equals("./")){
                continue;
            }else{
                mainF=mainF+1;
            }
        }
        return mainF;
    }
}