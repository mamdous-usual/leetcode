class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        mergedList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];

            int prevEnd = mergedList.get(mergedList.size() - 1)[1];

            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            if (prevEnd >= currentStart) {
                mergedList.get(mergedList.size() - 1)[1] = Math.max(prevEnd, currentEnd);
            } else {
                mergedList.add(currentInterval);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}