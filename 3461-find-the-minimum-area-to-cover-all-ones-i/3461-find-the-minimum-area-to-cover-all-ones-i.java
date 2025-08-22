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
                    System.out.println("(" + i + ", " + j + ")");
                    if (i < minI) {
                        minI = i;
                    }
                    
                    if (i > maxI) {
                        maxI = i;
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
        System.out.println("minI: " + minI + "\nmaxI: " + maxI + "\nminJ: " + minJ + "\nmaxJ: " + maxJ);
        return (maxJ - minJ + 1) * (maxI - minI + 1);
    }
}