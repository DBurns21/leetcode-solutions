class Solution {
    public int minimumArea(int[][] grid) {
        //left to right
        int minI = grid.length;
        int maxI = 0;
        int minJ = grid[0].length;
        int maxJ = 0;

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
        return (maxJ - minJ + 1) * (maxI - minI + 1);
    }
}