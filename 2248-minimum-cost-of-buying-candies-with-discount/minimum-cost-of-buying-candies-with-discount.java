class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int n = cost.length -1;
        while(n >=0) {
            ans += cost[n];
            if(n-1 > -1) {
                ans += cost[n-1];
                n--;
            }
            n -= 2;
        }
        return ans;
    }
}