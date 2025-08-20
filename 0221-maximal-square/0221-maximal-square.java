class Solution {
    private int maxSquare(int i, int j, char[][] matrix, int[] ans) {

        if (i == matrix.length || j == matrix[0].length || i < 0 || j < 0) {
            return 0;
        }

        int right = maxSquare(i, j+1, matrix, ans);
        int down = maxSquare(i+1, j, matrix, ans);
        int diagonal = maxSquare(i+1, j+1, matrix, ans);

        if (matrix[i][j] == '0') {
            return 0;
        }

        int value =  1 + Math.min(right, Math.min(down, diagonal));
        ans[0] = Math.max(ans[0], value);

        return value;
    }

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