class Solution {
    public int numSubmat(int[][] mat) {
       int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0){
                    dp[i][j] = mat[i][j];
                }
                else if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = 1 + dp[i][j-1];
                }

                int current = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    current = Math.min(dp[k][j], current);
                    if (current == 0) {
                        break;
                    }
                    ans += current;
                }

            }
        }

        return ans; 
    }
}