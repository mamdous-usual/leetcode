class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long covered = 0;

        int start = meetings[0][0];
        int end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int s = meetings[i][0];
            int e = meetings[i][1];

            if (s <= end) {
                end = Math.max(end, e);
            } else {
                covered += (end - start + 1);

                start = s;
                end = e;
            }
        }

        covered += (end - start + 1);

        return (int) (days - covered);

    }
}