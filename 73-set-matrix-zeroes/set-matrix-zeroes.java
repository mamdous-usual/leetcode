class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] zeroRow = new boolean[m];
        boolean[] zeroCol = new boolean[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(zeroRow[i] == true || zeroCol[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

/*
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] copy = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n;j++) {
                if(matrix[i][j] == 0) {
                    for(int k=0; k<m; k++) {
                        copy[k][j] = 0;
                    }
                    for(int k=0; k<n; k++) {
                        copy[i][k] = 0;
                    }
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
    }
    */
}