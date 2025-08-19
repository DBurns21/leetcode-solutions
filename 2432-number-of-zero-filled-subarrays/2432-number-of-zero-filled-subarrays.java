//the hardest part of this problem was figuring out the math and that wasn't too bad once I wrote it out
//and realized that at each additional zero in a row I would add the amount of zeroes in a row to the total subarray amount
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