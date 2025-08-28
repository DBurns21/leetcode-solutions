class Solution {
    public int[][] sortMatrix(int[][] grid) {
        ArrayList<Integer> sorted = new ArrayList<>();
        int n = grid.length;

        int col = 0;
        int row = 0;

        //this loop does all of the decreasing numbers
        for (int i = 0; i < n-1; ++i) {
            row = i;
            col = 0;
            sorted.add(grid[row][col]);
            row++;
            col++;
            while (row < n) {
               for (int k = 0; k < sorted.size(); ++k) {
                if (grid[row][col] > sorted.get(k)) {
                    sorted.add(k, grid[row][col]);
                    break;
                }
                else if (k == sorted.size()-1) {
                    sorted.add(grid[row][col]);
                    break;
                }
               }
               row++;
               col++;
            }

            row--;
            col--;
            while (!sorted.isEmpty()) {
                grid[row][col] = sorted.remove(sorted.size()-1);

                row--;
                col--;
            }

            /*for (int k = 0; k < sorted.size(); ++k) {
                System.out.println(sorted.get(k) + ", ");
            }
            //only needed during testing
            sorted.clear();
            */
        }
        



        row = 0;
        //this loop does all the increasing numbers
        for (int  i = 1; i < n-1; ++i) {
            row = 0;
            col = i;
            sorted.add(grid[row][col]);
            row++;
            col++;
            while (col < n) {
               for (int k = 0; k < sorted.size(); ++k) {
                if (grid[row][col] < sorted.get(k)) {
                    sorted.add(k, grid[row][col]);
                    break;
                }
                else if (k == sorted.size()-1) {
                    sorted.add(grid[row][col]);
                    break;
                }
               }
               row++;
               col++;
            }

            row--;
            col--;
            while (!sorted.isEmpty()) {
                grid[row][col] = sorted.remove(sorted.size()-1);

                row--;
                col--;
            }

        }
        return grid;
    }
}