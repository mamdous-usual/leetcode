class Solution {
    public int dayOfYear(String date) {
        int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        String[] dateVal = date.split("-");
        int year = Integer.parseInt(dateVal[0]);
        int month = Integer.parseInt(dateVal[1]);
        int days = Integer.parseInt(dateVal[2]);

        int totalDays = days;

        for (int i = 0; i < month-1; i++) {
            totalDays += daysOfMonth[i];
        }

        if (month > 2 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))) { // leap year logic
            totalDays++;
        }

        return totalDays;
    }
}