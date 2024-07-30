func lengthOfLastWord(s string) int {
    
    length:=len(s)

    count :=0
    firstIndex :=0

    for i:=length-1;i>=0;i--{
        if(s[i] != ' '){
            firstIndex=i
            break
        }
    }
    
    for j:=firstIndex;j>=0;j--{
        if(s[j]==' '){
            break
        }else{
            count +=1
        }
    }
    if(count==0){
        return 1;
    }
    
    return count
    
}