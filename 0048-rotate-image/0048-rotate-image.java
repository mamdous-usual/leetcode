class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length;

        // Transpose
       for(int i=0; i<n; i++)  {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
       }

       for(int i=0; i<n; i++) {
            int left = 0, right = n - 1;

            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
       }
    }
    /*
        public void rotate(int[][] matrix) {
        int n = matrix.length; // square
        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                temp[j][n-i-1] = matrix[i][j]; // main point -> n-i-1 -> clockwise 90
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
    */
}