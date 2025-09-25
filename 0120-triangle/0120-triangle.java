class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        if (size == 1) {
            return triangle.get(0).get(0);
        }

        List<int[]> dp = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            dp.add(new int[i+1]);
        }

        for (int i = 0; i < size; ++i) {
            dp.get(size-1)[i] = triangle.get(size-1).get(i);
        }

        for (int i = size-2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                int curr = triangle.get(i).get(j);
                int down = dp.get(i+1)[j] + curr;
                int downRight = dp.get(i+1)[j+1] + curr;

                if (down > downRight) {
                    dp.get(i)[j] = downRight;
                }
                else {
                    dp.get(i)[j] = down;
                }
            }
        }

        return dp.get(0)[0];
    }
}