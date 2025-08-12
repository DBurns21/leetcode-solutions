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

        int ifSkipped = dp(total, powers, index - 1, memo) % MOD;
        int notSkipped = 0;

        if (powers[index] <= total) { 
            notSkipped = dp(total - powers[index], powers, index - 1, memo) % MOD;
        }
        return memo[index][total] = ifSkipped + notSkipped;
    }

    public int numberOfWays(int n, int x) {
        List<Integer> answers = new ArrayList<>();
        int[] powers = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            powers[i] = (int)Math.pow(i, x);
        }

        int[][] memo = new int[powers.length][n + 1];
        for (int i = 0; i < powers.length; ++i) {
            for (int j = 0; j <= n; ++j) {
                memo[i][j] = -1;
            }
        }

        return dp(n, powers, powers.length - 1, memo);
    }
}