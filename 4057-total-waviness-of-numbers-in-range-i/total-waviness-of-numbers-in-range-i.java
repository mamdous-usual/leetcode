class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;

        for (int i = num1; i <= num2; i++) {
            res += helper(i);
        }

        return res;
    }

    private int helper(int num) {
        String s = String.valueOf(num);

        if (s.length() < 3) return 0;

        int waviness = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char prev = s.charAt(i - 1),
            curr = s.charAt(i),
            next = s.charAt(i + 1);

            if ((curr > prev && curr > next) ||
                (curr < prev && curr < next)) {
                waviness++;
            }
        }

        return waviness;
    }
}