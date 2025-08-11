class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] answers = new int[queries.length];
        String nbinary = Integer.toBinaryString(n);
        List<Integer> powers = new ArrayList<>();

        int current = 0;
        for (int i = 0; i < nbinary.length(); ++i) {
            if (nbinary.charAt(i) == '1') {
                powers.add((int)Math.pow(2,nbinary.length() - i - 1));
            }
        }
        Collections.reverse(powers);

        for (int i = 0; i < queries.length; ++i) {

            int j = queries[i][0];
            long currentAnswer = 1;
            while (j <= queries[i][1]) {
                currentAnswer = (currentAnswer * powers.get(j)) % 1000000007;
                j++;
            }
            answers[i] = (int)currentAnswer;
        }
        return answers;
    }
}