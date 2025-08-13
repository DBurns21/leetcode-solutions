class Solution {
    private final int largestPower = 1162261467;

    public boolean isPowerOfThree(int n) {
        return (n > 0 && largestPower % n == 0);
    }
}