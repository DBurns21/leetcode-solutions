//Pretty much the exact same as the previous three power questions except this time you check if it is cleanly divisible by four instead
//at the end you just return if it is equal to 1 or 4 since those are the two smallest powers we can get in this problem.
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        /*
        while (n > 4) {
            if (n % 4 != 0) {
                return false;
            }

            n /= 4;
        }

        return n == 1 || n == 4;
        */

        //Integer.bitCount return the number of one bits in a number so for example 01100 has 2 set bits and 1101101 has 5 set bits
        //so here we start off like in the power of 2 problem but we also check to see if the amount of one bits modded by 2 is 0 
        //we do so since all powers of four are powers of two but not all powers of two are powers of four so this checks for that.
        return (n & (n-1)) == 0 && Integer.bitCount(n-1)%2 == 0;

    }
}