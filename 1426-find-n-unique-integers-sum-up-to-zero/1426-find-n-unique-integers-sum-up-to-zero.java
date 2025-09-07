class Solution {
    public int[] sumZero(int n) {
        int[] uniqueZero = new int[n];

        if (n % 2 == 1) {
            uniqueZero[n/2] = 0;
        }

        for (int i = 0; i < n/2; ++i) {
            int current  = n/2 - i;
            uniqueZero[i] = current;
            uniqueZero[n - i - 1] = (-1) * current;
        }

        return uniqueZero;
    }
}