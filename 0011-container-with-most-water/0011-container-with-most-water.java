class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[right] >= height[left]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}