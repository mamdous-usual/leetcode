class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0; 
        int colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int k=colBegin; k<=colEnd; k++) {
                ans.add(matrix[rowBegin][k]);
            }
            rowBegin++;

            for(int k=rowBegin; k<=rowEnd; k++) {
                ans.add(matrix[k][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                for(int k=colEnd; k>=colBegin; k--) {
                    ans.add(matrix[rowEnd][k]);
                }
                rowEnd--;
            }

            if(colBegin <= colEnd) {
                for(int k=rowEnd; k>=rowBegin; k--) {
                    ans.add(matrix[k][colBegin]);
                }
                colBegin++;
            }

        }

        return ans;
    }
}