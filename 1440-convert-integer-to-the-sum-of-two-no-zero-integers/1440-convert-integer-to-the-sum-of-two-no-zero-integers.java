class Solution {
    private boolean nonZero(int num) {
        while (num > 9) {
            if (num % 10 == 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }


    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; ++i) {
            if (nonZero(i) && nonZero(n-i)) {
                return new int[] {i, n-i};
            }
        }
        return new int[] {};
    }
}