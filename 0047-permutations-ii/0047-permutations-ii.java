class Solution {
    int N;
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>(); // List to store all unique permutations
        N = nums.length; // Length of the input array
        Arrays.sort(nums); // Sort the array to handle duplicates
        helper(nums, new ArrayList<Integer>(), new ArrayList<Integer>()); // Start backtracking
        return res; // Return the list of unique permutations
    }

    public void helper(int[] nums, List<Integer> curr, List<Integer> consumed) {
        // Base case: if the size of current list equals the length of nums array, a unique permutation is formed
        if (curr.size() == N) {
            res.add(new ArrayList<Integer>(curr)); // Add a copy of current list to result list
        }

        // Recursive case: iterate through each index in nums
        for (int i = 0; i < N; i++) {
            if (!consumed.contains(i)) { // Skip if the index is already consumed
                curr.add(nums[i]); // Add the element to current list
                consumed.add(i); // Mark the index as consumed
                helper(nums, curr, consumed); // Recursively call helper to explore further permutations
                curr.remove(curr.size() - 1); // Backtrack by removing the last added element
                consumed.remove(consumed.size() - 1); // Remove the index from consumed list
                
                // Skip duplicates
                while (i < N - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}