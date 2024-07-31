func plusOne(digits []int) []int {
    n := len(digits)
    sum:=digits[len(digits)-1]+1

    digits[len(digits)-1]= sum % 10
    accu := sum / 10
    for i:=n-2;i>=0;i--{
        if(accu == 0){
            break
        }
        sum=digits[i]+accu
        digits[i]=(sum)%10
        accu=(sum) / 10
    }
    if(accu != 0){
        digits = append([]int{accu}, digits...)
    }
    return digits
}