class Solution {
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

        return result;
    }
}