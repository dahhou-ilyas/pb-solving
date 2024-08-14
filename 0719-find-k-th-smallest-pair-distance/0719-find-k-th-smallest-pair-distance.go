package main

import (
	"fmt"
	"sort"
)

func countPairs(nums []int, d int) int {
	count := 0
	left := 0
	for right := 0; right < len(nums); right++ {
		for nums[right] - nums[left] > d {
			left++
		}
		count += right - left
	}
	return count
}

func smallestDistancePair(nums []int, k int) int {
	sort.Ints(nums)

	low, high := 0, nums[len(nums)-1] - nums[0]
	for low < high {
		mid := (low + high) / 2
		if countPairs(nums, mid) < k {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return low
}