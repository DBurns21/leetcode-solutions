//orignally had a runtime of 155 ms which I thought was crazy but then I removed my print two print statements that printed every current location and it dropped down to 4ms
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = 0;
        Boolean up = true;
        int location = 0;
        int[] diagonal = new int[m*n];
        
        while (i < m && j < n) {
            diagonal[location] = mat[i][j];
            location++;

            if (up) {
                if( i == 0) {
                    up = false;
                    if (j == n-1) {
                        i++;
                    }
                    else {
                        j++;
                    }
                }
                else if (j == n-1) {
                    up = false;
                    i++;
                }
                else {
                    i--;
                    j++;
                }
            }
            else {
                if (j == 0) {
                    up = true;
                    if (i == m-1) {
                        j++;
                    }
                    else {
                        i++;
                    }
                }
                else if (i == m-1) {
                    up = true;
                    j++;
                }
                else {
                    i++;
                    j--;
                }
            }
        }
        return diagonal;
    }
}