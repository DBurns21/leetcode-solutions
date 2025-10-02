class Solution {
    private int bottleExchange(int numBottles, int numExchange, int leftover) {
        int totalBottles = numBottles + leftover;
        if (totalBottles < numExchange) {
            return numBottles;
        }

        int exchanges = 0;
        while (numExchange <= totalBottles) {
            totalBottles -= numExchange;
            numExchange++;
            exchanges++;
        }
        
        

        return numBottles + bottleExchange(exchanges, numExchange, totalBottles);
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return bottleExchange(numBottles, numExchange, 0);
    }
}