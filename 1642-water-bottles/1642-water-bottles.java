class Solution {
    private int bottleExchange(int numBottles, int numExchange, int leftover) {
        System.out.println("Current bottles: " + numBottles + "\nCurrent leftover: " + leftover);
        if (numBottles + leftover < numExchange) {
            return numBottles;
        }

        int exchanges = (numBottles + leftover) / numExchange;

        return numBottles + bottleExchange(exchanges, numExchange, numBottles-(exchanges*numExchange) + leftover);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        return bottleExchange(numBottles, numExchange, 0);
    }
}