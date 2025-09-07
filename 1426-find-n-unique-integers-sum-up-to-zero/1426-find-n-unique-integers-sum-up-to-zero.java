class Solution {
    public int[] sumZero(int n) {
        int[] uniqueZero = new int[n];

        //due to the fact that java makes every spot in an array a 0 when created we don't actually need to
        //check if n is evven or odd
        //if (n % 2 == 1) {
        //    uniqueZero[n/2] = 0;
        //}

        for (int i = 0; i < n/2; ++i) {
            int current  = n/2 - i;
            uniqueZero[i] = current;
            uniqueZero[n - i - 1] = (-1) * current;
        }

        return uniqueZero;
    }
}