class Solution {
    private double getSoupOdds(int a, int b, Map<Integer, Map<Integer, Double>> dp) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }

        if (dp.containsKey(a) && dp.get(a).containsKey(b)) {
            return dp.get(a).get(b);
        }

        double result = 0.25 * (getSoupOdds(a-4, b, dp) + getSoupOdds(a-3, b-1, dp) + getSoupOdds(a-2, b-2, dp) + getSoupOdds(a-1, b-3, dp));
        dp.computeIfAbsent(a, i -> new HashMap<>()).put(b, result);
        return result;
    }

    public double soupServings(int n) {
        //because of the rounding any n above 4800 is close enough to 1 that the answer will be correct so rather than waste time trying to find the solution you can just simply return 1.
        if (n > 4800) {
            return 1;
        }

        n = (int)Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            //1e-5 is the same as 10^-5 for those who don't remember math terms sometimes aka me
            if (getSoupOdds(i, i, dp) > 1 - 1e-5) {
                return 1.0;
            }
        }

        return getSoupOdds(n, n, dp);
    }
}