import "fmt"
func lemonadeChange(bills []int) bool {
    numberOf5 := 0
    numberOf10 := 0
    for _, bill := range bills {
        if bill == 5 {
            numberOf5 = numberOf5 + 1
        }else if bill == 10{
            if numberOf5 <= 0 {
                return false
            }
            numberOf10 =numberOf10 +1
            numberOf5 = numberOf5 -1
        }else if bill == 20{
            if (numberOf10 > 0){
                numberOf10=numberOf10-1
                if ( numberOf5 <= 0 ){
                    return false
                }
                numberOf5=numberOf5-1
            }else if (numberOf5 >=3){
                numberOf5 = numberOf5 - 3
            }else{
                return false
            }
        }
    }
    return numberOf5>=0
}