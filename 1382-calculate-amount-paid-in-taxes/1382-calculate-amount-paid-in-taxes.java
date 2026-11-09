class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0.0;
        int prev = 0;

        for (int[] b : brackets) {
            int upper = b[0];
            int percent = b[1];

            if (income > prev) {
                int taxable = Math.min(income, upper) - prev;
                totalTax += taxable * percent / 100.0;
                prev = upper;
            } else {
                break;
            }
        }
        return totalTax;
    }
}