class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            int erea=(right-left)*Math.min(height[left],height[right]);
            if(erea > max){
                max=erea;
            }
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;     
    }
}