class Solution {
    private boolean isIncreasing(List<Integer> nums, int k) {
        if (k == 1) {
            return true;
        }

        for(int i = 0; i <= nums.size()-(2*k); ++i) {
            boolean increasing = true;
            //System.out.println("i is " + i);
            //System.out.println("Checking for range " + i + " to " + (i + k - 1));

            for (int a = i; a < i + k - 1; ++a) {
                int b = a + k;
                if (nums.get(a) >= nums.get(a+1) || nums.get(b) >= nums.get(b+1)) {
                    i = a;
                    increasing = false;
                    break;
                }
            }

            if (increasing) {
                return true;
            }
        }
        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int high = nums.size() - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isIncreasing(nums, mid)) {
                if (mid == high) {
                    return mid;
                }
                else if (isIncreasing(nums, mid+1)) {
                    low = mid + 1;
                }
                else {
                    return mid;
                }
            }
            else {
                high = mid - 1;
            }
        }

        return 1;
    }
}