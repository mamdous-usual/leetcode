class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0; // arr1;
        int j = 0; // arr2;

        Set<Integer> set = new HashSet<>();

        while(i< arr1.length && j<arr2.length) {
            if(arr1[i] == arr2[j]) {
                set.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) i++;
            else j++;
        }

        int[] result = new int[set.size()];
        int index = 0;
        for(int num : set) {
           result[index] = num;
           index++;
        }

        return result; 
    }
}