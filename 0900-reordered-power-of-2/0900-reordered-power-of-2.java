class Solution {
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


        for (int i = 1; i < 31; i++) {
            boolean isEqual = true;
            int[] power = numberFrequency((int)Math.pow(2, i));
            for (int j = 0; j < 10; ++j) {
                if (power[j] != frequency[j]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return true;
            }
        }


       return false;
    }
}