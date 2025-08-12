class Solution {

    final int MOD = 1000000007;
    private int dp(int total, int[] powers, int index, int[][] memo) {
        if (total == 0) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }

        if (memo[index][total] != -1) {
            return memo[index][total];
        }

        //you will always want to compute other possible option for if you did skip the current power even if it is less than the total
        int ifSkipped = dp(total, powers, index - 1, memo) % MOD;
        int notSkipped = 0;
        //in the event that we do actually skip this power then only 0 will be added to the return value causing no harm but if we don't skip we check what would happen
        if (powers[index] <= total) { 
            notSkipped = dp(total - powers[index], powers, index - 1, memo) % MOD;
        }
        //a little lazy but we can return the current memo and also set it equal to ifSkipped and notSkipped in the same line
        return memo[index][total] = ifSkipped + notSkipped;
    }

    public int numberOfWays(int n, int x) {
        int[] powers = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            powers[i] = (int)Math.pow(i, x);
        }

        // is used to store results so that if we come across a combination we have found before we can skip the process of finding it again and just get the result
        int[][] memo = new int[powers.length][n + 1];
        for (int i = 0; i < powers.length; ++i) {
            for (int j = 0; j <= n; ++j) {
                memo[i][j] = -1;
            }
        }

        return dp(n, powers, powers.length - 1, memo);
    }
}