class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int highest = 0;

        for (int i = 0; i < nums.length; ++i) {
            freq.merge(nums[i], 1, Integer::sum);
            if (freq.get(nums[i]) > highest) {
                highest = freq.get(nums[i]);
            }
        }

        int ans = 0;
        for (int value : freq.values()) {
            if (value == highest) {
                ans += highest;
            }
        }
        return ans;
    }
}