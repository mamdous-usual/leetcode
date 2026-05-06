class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;
        for (int i = 0; i < rows; i++) { // i = row, j = col
            int p = 0;
            for (int j = 0; j < cols; j++) { 
                if (boxGrid[i][j] == '.') {
                    char temp = boxGrid[i][j];
                    boxGrid[i][j] = boxGrid[i][p];
                    boxGrid[i][p] = temp;
                    p++;
                } else if (boxGrid[i][j] == '*') {
                    p = j + 1;
                }
                   
            }
        }
        
        char[][] ans = new char[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                ans[j][rows - 1 - i] = boxGrid[i][j];
                
        return ans;
    }
}