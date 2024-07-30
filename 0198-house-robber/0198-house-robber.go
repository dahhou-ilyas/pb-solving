func rob(nums []int) int {
    rob1:=0
    rob2:=0
    
    for _,n := range nums {
        temp := math.Max(float64(n+rob1) ,float64(rob2))
        rob1=rob2
        rob2=int(temp)
    }
    return rob2
}