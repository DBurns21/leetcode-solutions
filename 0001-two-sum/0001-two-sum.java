class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> remainders = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            remainders.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            int leftover = target - nums[i];
            if (remainders.containsKey(leftover) && i != remainders.get(leftover)) {
                ans[0] = remainders.get(leftover);
                ans[1] = i;
            }
        }

        
        return ans;
    }
}