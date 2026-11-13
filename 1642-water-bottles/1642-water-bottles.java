class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

    /*
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed = 0;
    
        while(numBottles >= numExchange) {
            consumed += numExchange;
            numBottles -= numExchange;
            numBottles++;
        }
    
        return consumed + numBottles;
    }
    */

    /*
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int emptyBottles = numBottles;
    
        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            totalDrunk += newBottles;
            emptyBottles = (emptyBottles % numExchange) + newBottles;
        }
    
        return totalDrunk;
    } 
    */
}