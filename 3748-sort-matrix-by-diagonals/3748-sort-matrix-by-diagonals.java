class Solution {
    public int[][] sortMatrix(int[][] grid) {
        ArrayList<Integer> sorted = new ArrayList<>();
        int n = grid.length;

        int col = 0;
        int row = 0;

        //this loop does all of the decreasing numbers
        //since the corners don't have any diagonals for us to swap them with we don't have to check that diagonal
        for (int i = 0; i < n-1; ++i) {
            row = i;
            col = 0;
            //we can either add the first int of the diagonal here or we could also check if sorted.size is equal to zero in the while loop and add it then
            //the reason for that is because if we don't have anything in sorted the innermost for loop will never run
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

            //I don't think it is very pretty this way but since row will == n here we need to knock it and col down one so that we can start on the grid
            row--;
            col--;
            while (!sorted.isEmpty()) {
                //ArrayList.remove also returns the element at that index so we don't have to worry about clearing the list when we are done with this diagonal
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