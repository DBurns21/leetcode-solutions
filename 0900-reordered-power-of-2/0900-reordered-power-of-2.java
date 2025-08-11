//Orignally I thought I was going to need to find all possible permutations for the number I was given but I ended up finding a much more efficient way
//By instead finding the frequency in which all the numbers popped up in the given number I could compare that to all of the powers of two within 10^9.

class Solution {
    //helper fuction that finds the frequency of each number in the number it is given.
    private int[] numberFrequency(int num) {
        String s = String.valueOf(num);
        int[] frequency = new int[10];
        Arrays.fill(frequency, 0);
        for (int i = 0; i < s.length(); i++) {
            int current = Character.getNumericValue(s.charAt(i));
            frequency[current]++;
        }
        return frequency;
    }

    public boolean reorderedPowerOf2(int n) {
        if (n <=0) {
            return false;
        }
        if ((n & (n-1)) == 0) {
            return true;
        }

        int[] frequency = numberFrequency(n);

        //here I create a frequency arrary for each power of two and then check it agaisnt the one I made for the number I was given.
        //the inside loop also ends early if a the frequency doesn't match for the current digit.
        for (int i = 1; i < 31; i++) {
            boolean isEqual = true;
            int[] power = numberFrequency((int)Math.pow(2, i));
            for (int j = 0; j < 10; ++j) {
                if (power[j] != frequency[j]) {
                    isEqual = false;
                    break;
                }
            }
            //just to make sure I don't have make extra checks I check here to see if isEqual is still true and if it is we can quit searching and return true.
            if (isEqual) {
                return true;
            }
        }


       return false;
    }
}