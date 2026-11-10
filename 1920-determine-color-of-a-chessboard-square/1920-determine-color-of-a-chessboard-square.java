class Solution {
    public boolean squareIsWhite(String coordinates) {
       int row = coordinates.charAt(1) - 0;
       int col = coordinates.charAt(0) - 'a' + 1;

       return ((row + col) & 1) == 1; // (row + col ) => odd -> white; even -> black; 
    }
}