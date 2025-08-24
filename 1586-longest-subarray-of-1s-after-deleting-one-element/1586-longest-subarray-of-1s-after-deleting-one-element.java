class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int length = 0;
        int zeros = 0;
/*
        if (nums[0] == 0) {
            while (nums[start] == 0) {
                start++;
                end++;
            }
        }
        */

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;

                while (zeros > 1) {
                    if (nums[start] == 0) {
                        zeros--;
                    }
                    start++;
                }             
            }

            if (length < end - start ) {
                length = end - start ;
            }
            //System.out.println("Start: " + start + "\nEnd: " + end + "\nSize: " + length +"\nlastZero:" + lastZero + "\n");
            end++;
        }
        return length;
    }
}