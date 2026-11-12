class Solution {
    // Arithmetic Progression -> O(1)
    public int totalMoney(int n) {
        int terms = n/7; // weeks

        int first = 28; // first week sum
        int last = 28 + (terms-1) * 7; // a + (n-1) * d; d = 7

        int result = terms * (first + last) / 2; // sum of nth terms in an AP -> Sn -> n * (a + l) / 2;

        // remaining days
        int remain = n % 7;
        int firstTerm = (1+terms);
        int lastTerm = firstTerm + remain - 1; // d = 1
        
        result += remain * (firstTerm + lastTerm) /2;

        return result;
    }

    /*
    // Simulation -> O(n)
    public int totalMoney(int n) {
        int startMonday = 1;
        int result = 0;
        while(n > 0) {
            int money = startMonday;

            for(int i=1; i<=Math.min(n, 7); i++) {
                result += money;
                money++;
            }

            n -= 7;
            startMonday++;
        }

        return
    }
    */
}