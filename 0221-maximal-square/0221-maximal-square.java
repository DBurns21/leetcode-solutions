class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }
}