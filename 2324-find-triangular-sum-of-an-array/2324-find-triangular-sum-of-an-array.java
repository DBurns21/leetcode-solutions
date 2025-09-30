class Solution {
    public int triangularSum(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] addedNums = new int[length-1];

        for (int i = 0; i < length-1; ++i) {
            addedNums[i] = (nums[i] + nums[i+1]) % 10;
        }

        return triangularSum(addedNums);
    }
}