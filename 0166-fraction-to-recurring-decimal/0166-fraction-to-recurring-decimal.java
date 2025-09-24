class Solution {
    

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            ans.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        ans.append(dividend/divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return ans.toString();
        }

        ans.append(".");

        HashMap<Long, Integer> remainToPos = new HashMap<>();
        while (remainder != 0) {
            if (remainToPos.containsKey(remainder)) {
                ans.insert(remainToPos.get(remainder), "(");
                ans.append(")");
                break;
            }
            remainToPos.put(remainder, ans.length());
            remainder *= 10;
            ans.append(remainder/ divisor);
            remainder %= divisor;
        }


        return ans.toString();
    }
}