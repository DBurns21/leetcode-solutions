class Solution {
    //since we are using int it only goes up to 32 bits
    //this means that the largest base power of 3 we can get is 1162261467
    private final int largestPower = 1162261467;

    public boolean isPowerOfThree(int n) {
        //since any base of 3 is divisible by only any of base power of 3 we just
        //need to check if we divide n by the largest base 3 power we can get and see if their is no remainder
        return (n > 0 && largestPower % n == 0);
    }
}