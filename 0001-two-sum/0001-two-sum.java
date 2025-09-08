class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> remainders = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            remainders.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (remainders.containsKey(target-nums[i]) && i != remainders.get(target-nums[i])) {
                ans[0] = remainders.get(target-nums[i]);
                ans[1] = i;
            }
        }

        
        return ans;
    }
}