class Solution {

    public int[] fillArrFromLayer(int[][]grid, int minr, int minc, int maxr, int maxc){
        int size = 2 * (maxr - minr + maxc - minc) ;
        int arr[] = new int[size];
        int idx=0;
        //left wall
        for(int i=minr, j=minc;i<=maxr;i++){
            arr[idx] = grid[i][j];
            idx++;
        }

        //bottom wall
        for(int i=maxr, j=minc+1;j<=maxc;j++){
            arr[idx] = grid[i][j];
            idx++;
        }

        //right wall
        for(int i=maxr-1, j=maxc;i>=minr;i--){
            arr[idx] = grid[i][j];
            idx++;
        }

        //top wall
        for(int i=minr, j=maxc-1 ;j>=minc+1;j--){
            arr[idx] = grid[i][j];
            idx++;
        }

        return arr;
    }

    public void reverse(int arr[], int s, int e){
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }    

    public void rotatearr(int arr[], int k){
        k = k % arr.length;
        if(k < 0){
            k= k + arr.length;
        }
        reverse(arr, 0, arr.length - k -1);
        reverse(arr,arr.length - k , arr.length-1);
        reverse(arr, 0, arr.length-1);
        
    }

    public void fillLayerFromArr(int[][]grid, int arr[], 
    int minr, int minc, int maxr, int maxc){
        int idx=0;
        //left wall
        for(int i=minr, j=minc;i<=maxr;i++){
            grid[i][j] = arr[idx];
            idx++;
        }
        //bottom wall
        for(int i=maxr, j=minc + 1;j<=maxc;j++){
            grid[i][j] = arr[idx];
            idx++;
        }
        //right wall
        for(int i=maxr-1, j=maxc;i>=minr;i--){
            grid[i][j] = arr[idx];
            idx++;
        }
        //top wall
        for(int i=minr, j=maxc-1;j>=minc+1;j--){
            grid[i][j] = arr[idx];
            idx++;
        }

    }

    public void rotate(int [][]grid, int k, int minr, int minc, int maxr, int maxc ){
        while(minr < maxr && minc < maxc){
            int arr[] = fillArrFromLayer(grid, minr, minc, maxr, maxc);
            rotatearr(arr, k);
            fillLayerFromArr(grid, arr, minr, minc, maxr, maxc);
            minr++; maxr--; minc++; maxc--;
        }
        

    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int minr = 0, minc=0, maxr=grid.length-1, maxc = grid[0].length-1;
        rotate(grid, k, minr,minc, maxr, maxc);
        return grid;
        
    }
}