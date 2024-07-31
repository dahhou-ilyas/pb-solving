func plusOne(digits []int) []int {
    n := len(digits)
    // Start from the end of the digits array
    for i := n - 1; i >= 0; i-- {
        if digits[i] < 9 {
            // If the current digit is less than 9, simply increment it and return the result
            digits[i]++
            return digits
        }
        // Set the current digit to 0 and continue to the next digit
        digits[i] = 0
    }
    // If all digits were 9, we need to add an extra digit at the beginning
    result := make([]int, n+1)
    result[0] = 1
    return result
}