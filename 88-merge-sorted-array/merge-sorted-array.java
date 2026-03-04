class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = 0; // arr1
        int j = 0; // arr2
        int[] arr = new int[arr1.length];
        int index = 0; // arr

        while (i < m && j < n) {
            if(arr1[i] <= arr2[j]){
                arr[index] = arr1[i];
                index++;
                i++;
            } else {
                arr[index] = arr2[j];
                index++;
                j++;
            }
        }

        while(i < m) {
            arr[index] = arr1[i];
            index++;
            i++;
        }

        while(j < n) {
            arr[index] = arr2[j];
            index++;
            j++;
        }

        for(int k = 0; k < m+n; k++){
           arr1[k] = arr[k];
        }  
    }
}