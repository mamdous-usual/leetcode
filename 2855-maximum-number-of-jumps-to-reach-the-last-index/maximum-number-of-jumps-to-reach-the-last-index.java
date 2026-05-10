class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[] prefix=new int[n];

        for(int i=0;i<n;i++){
            if(i!=0&&prefix[i]==0) continue;
             for(int j=i+1;j<n;j++){
                if(-target<=(nums[j]-nums[i])&&(nums[j]-nums[i])<=target ){
                    prefix[j]=Math.max(prefix[j],prefix[i]+1);
                }
             }
        }
        return prefix[n-1]==0?-1:prefix[n-1];
    }
}