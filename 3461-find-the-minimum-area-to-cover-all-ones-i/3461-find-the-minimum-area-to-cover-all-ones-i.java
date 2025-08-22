class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minI = m;
        int maxI = 0;
        int minJ = n;
        int maxJ = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minI = i;
                    i = m;
                    break;
                }
            }
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1;j >= 0; j--) {
                if (grid[i][j] == 1) {
                    maxI = i;
                    i = -1;
                    break;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    minJ = j;
                    j = n;
                    break;
                }
            }
        }

        for (int j = n-1; j >= 0; j--) {
            for (int i = m-1; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    maxJ = j;
                    j = -1;
                    break;
                }
            }
        }

        /*
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1){
                    //since i only increases unlike j the current i will always be greater than or equal to maxI
                    maxI = i;
                    if (i < minI) {
                        minI = i;
                    }

                    if (j < minJ) {
                        minJ = j;
                    }

                    if (j > maxJ) {
                        maxJ = j;
                    }
                }
            }
        }
        */
        return (maxJ - minJ + 1) * (maxI - minI + 1);
    }
}