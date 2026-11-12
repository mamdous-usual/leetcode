class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int n = i;
            boolean isSelfDividing = true;

            while (n > 0) {
                int ld = n % 10;

                if (ld == 0 || i % ld != 0) {
                    isSelfDividing = false;
                    break;
                }
                n /= 10;
            }

            if (isSelfDividing) {
                ans.add(i);
            }
        }

        return ans;
    }
}