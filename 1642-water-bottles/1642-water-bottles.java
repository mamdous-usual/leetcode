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
}