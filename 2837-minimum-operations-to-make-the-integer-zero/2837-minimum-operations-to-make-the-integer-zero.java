class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int operations = 1;
        
        while (true) {
            long x = num1 - (long) num2 * operations;

            if (x < operations) {
                return -1;
            }

            if (operations >= Long.bitCount(x)) {
                return operations;
            }
            operations++;
        }
    }
}