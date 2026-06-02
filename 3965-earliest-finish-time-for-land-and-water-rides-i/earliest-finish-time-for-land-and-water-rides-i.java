class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
         int res = Integer.MAX_VALUE;

        int n = landStartTime.length;
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minEnd = Math.min(minEnd, landStartTime[i] + landDuration[i]);
        }
        int m = waterStartTime.length;

        for (int i = 0; i < m; i++) {
            res = Math.min(res, waterDuration[i] + Math.max(minEnd, waterStartTime[i]));
        }

        minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minEnd = Math.min(minEnd, waterStartTime[i] + waterDuration[i]);
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, landDuration[i] + Math.max(minEnd, landStartTime[i]));
        }

        return res;
    }
}