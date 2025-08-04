class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        int max = 2;
        int first = fruits[0];
        int second = -1;
        int currentMax = 1;
        int location = 0;

        for (int i = 1; i < fruits.length; ++i) {
            if (fruits[i] != first && second == -1) {
                second = fruits[i];
                currentMax++;
                location = i;
            }
            else if (fruits[i] == first || fruits[i] == second) {
                currentMax++;
            }
            else {
                i = location;
                first = fruits[i];
                second = -1;
                currentMax = 1;
            }

            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }
}