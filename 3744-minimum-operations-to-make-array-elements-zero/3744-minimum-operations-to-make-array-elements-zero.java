class Solution {
    private long operations(long n) {
        long operations = 0;
        int base = 1;
        int step = 1;

        while (base <= n) {
            long count = Math.min(n, base * 4 - 1) - base + 1;
            operations += count * step;
            base *= 4;
            step++;
        }

        return operations;

        /*
        for (int i = 0; i < size; ++i) {
            operations += (long)Math.floor(Math.log(i+nums[0]) / Math.log(4)) + 1;
        }

        int largestIndex = size-1;
        int nextLargestIndex = size-2;
        boolean noZeroes = false;

        return (long)Math.ceil((double)operations / 2);//operations - 1;
        */
    }

    public long minOperations(int[][] queries) {
        long answer = 0;

        for(int i = 0; i < queries.length; ++i) {
            long l = queries[i][0];
            long r = queries[i][1];

            double total = operations(r) - operations(l - 1);

            answer += (total + 1) / 2;
        }

        /*
        for (int i = 0; i < queries.length; ++i) {
            answer += operations(queries[i]);
        }
        */

        return answer;
    }
}