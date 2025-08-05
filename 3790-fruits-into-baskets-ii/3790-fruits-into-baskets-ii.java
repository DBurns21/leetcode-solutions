class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        if (fruits.length == 0 || baskets.length == 0) {
            return fruits.length;
        }
        int leftover = fruits.length;
        for (int i = 0; i < fruits.length; ++i) {            
            for (int j = 0; j < baskets.length; ++j) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = 0;
                    leftover--;
                    break;
                }
            }
        }
        return leftover;
    }
}