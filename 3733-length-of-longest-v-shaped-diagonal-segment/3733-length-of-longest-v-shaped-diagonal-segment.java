class Solution {
    private int search(int i, int j, int[] dir, int[][] grid, boolean hasTurned, boolean wasTwo, int num) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            //System.out.println("failed one: " + num + "  I: " + i + "  J: " + j);
            return 0;
        }
        int current = grid[i][j];
        if ((current != 0 && current != 2) || (wasTwo && current == 2) || (!wasTwo && current == 0)) {
            //System.out.println("failed two: " + num + "  I: " + i + "  J: " + j);
            return 0;
        }
        //System.out.println("I: " + i + "  J: " + j + "  dir: " + dir[0] + ", " + dir[1] + "  Num: " + num);//+ "  Current: " + grid[i][j] + "  wasTwo: " + wasTwo);

        if (current == 2) {
            wasTwo = true;
        }
        else {
            wasTwo = false;
        }
        int turnedLength = 0;
        if (!hasTurned) {
            int[] clockwise = new int[2];
            int temp = dir[0] * -1;
            clockwise[0] = dir[1];
            clockwise[1] = temp;
            turnedLength = search(i + clockwise[0], j + clockwise[1], clockwise, grid,  true, wasTwo, num + 10);
        }

        return 1 + Math.max(search(i + dir[0], j + dir[1], dir, grid, hasTurned, wasTwo, num), turnedLength);
    }

    private int startSearch(int i, int j, int m, int n, int[][] grid) {
        int[][] dir = {{1,1}, {1,-1}, {-1, -1}, {-1, 1}};
        int length = 1;

        int one = 1;
        int two = 1;
        int three = 1;
        int four = 1;

        if (i != m-1 && j != n-1) {
           // System.out.println("one: " + i + ", " + j);
            one = 1 + search(i + dir[0][0], j + dir[0][1], dir[0], grid, false, false, 1);
        }
        if (i != m-1 && j != 0) {
            //System.out.println("two: " + i + ", " + j);
            two = 1 + search(i + dir[1][0], j + dir[1][1], dir[1], grid, false, false, 2);
        }
        if (i != 0 && j != 0) {
            //System.out.println("three: " + i + ", " + j);
            three = 1 + search(i + dir[2][0], j + dir[2][1], dir[2], grid, false, false, 3);
        }
        if (i != 0 && j != n-1) {
            //System.out.println("four: " + i + ", " + j);
            four = 1 + search(i + dir[3][0], j + dir[3][1], dir[3], grid, false, false, 4);
        }
        length = Math.max(length, Math.max(one, Math.max(two, Math.max(three, four)))); 
        
        //System.out.println(length);
        return length;
    }

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int length = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    length = Math.max(length, startSearch(i, j, m, n, grid));
                }
            }
        }
        return length;
    }
}