class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j= n -1;
        int k = m+n -1;

        while(j >=0 ) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
    /*

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];

        int index = 0;
        for (int i = 0; i < m; i++) {
            ans[i] = nums1[i];
        }
        for (int i = m; i < m + n; i++) {
            ans[i] = nums2[index];
            index++;
        }
        Arrays.sort(ans);
        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
    */
}