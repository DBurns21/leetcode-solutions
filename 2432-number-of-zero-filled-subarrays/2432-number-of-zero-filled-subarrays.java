class Solution {
    public long zeroFilledSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        long numOfSubarrays = 0;
        long zeroRowLength = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                zeroRowLength++;
                numOfSubarrays += zeroRowLength;
            }
            else {
                zeroRowLength = 0;
            }
        }

        return numOfSubarrays;
    }
}