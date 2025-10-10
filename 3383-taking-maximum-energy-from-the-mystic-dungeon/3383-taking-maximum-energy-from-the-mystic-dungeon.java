class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int length = energy.length;
        int[] dp = new int[length];

        for (int i = length-k; i < length; ++i) {
            dp[i] = energy[i];
        }

        for (int i = length-k-1; i >= 0; --i) {
            dp[i] = energy[i] + dp[i + k];
        }

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            if(dp[i] > largest) {
                largest = dp[i];
            }
        }
        
        return largest;
    }
}