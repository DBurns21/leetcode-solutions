class Solution {
    public boolean isPowerOfTwo(int n) {
        //Since any number that is 0 or less can't be a power of two we can make that our base case
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}