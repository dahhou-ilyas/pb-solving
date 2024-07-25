class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, nums.length - mid);

        sortArray(left);
        sortArray(right);

        merge(nums, left, right);
        return nums;
    }

    private void merge(int[] nums, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, numsIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                nums[numsIndex++] = left[leftIndex++];
            } else {
                nums[numsIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            nums[numsIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            nums[numsIndex++] = right[rightIndex++];
        }
    }
}