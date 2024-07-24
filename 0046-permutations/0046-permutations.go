func permute(nums []int) [][]int {
	perms := [][]int{{}}

	for _, n := range nums {
		nextPerms := [][]int{}
		for _, p := range perms {
			for i := 0; i <= len(p); i++ {
				pCopy := append([]int(nil), p...)
				pCopy = append(pCopy[:i], append([]int{n}, pCopy[i:]...)...)
				nextPerms = append(nextPerms, pCopy)
			}
		}
		perms = nextPerms
	}
	return perms
}