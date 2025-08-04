class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        int max = 2;
        int first = fruits[0];
        int second = -1;
        int currentMax = 1;
        //location saves the spot where the last second varible was set so that we can start the next possible search from that point in the list.
        int location = 0;

        for (int i = 1; i < fruits.length; ++i) {
            //the first time that fruits[i] does not equal the first varible we set it to the second varible and save that location.
            if (fruits[i] != first && second == -1) {
                second = fruits[i];
                currentMax++;
                location = i;
            }
            else if (fruits[i] == first || fruits[i] == second) {
                currentMax++;
            }
            else {
                //since fruits[i] doesn't equal either value we reset the currentMax and restart the search from where we first found the second varible.
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