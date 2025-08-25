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

            //realized I could simplify my code since I had addition code due to having my if and if else statements backwards 
            //meaning if i == 0 I would also have to check if j == n-1 rather than first checking if j == n-1 and then if not checking if i == 0
            if (up) {
                if (j == n-1) {
                    up = false;
                    i++;
                }
                else if( i == 0) {
                    up = false;
                    j++;
                }
                else {
                    i--;
                    j++;
                }
            }
            else {
                if (i == m-1) {
                    up = true;
                    j++;
                }
                else if (j == 0) {
                    up = true;
                    i++;
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