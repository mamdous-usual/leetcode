class Solution {
   public boolean jumpRecur(int[] arr,int ind,boolean[] visited){
        int n=arr.length;
        if(ind<0 || ind>=n || visited[ind]==true)
        {
            return false;
        }
        if(arr[ind]==0)
        {
            return true;
        }
        visited[ind]=true;
        int nextVal=arr[ind]+ind;
        int prevVal=ind-arr[ind];
        return jumpRecur(arr,nextVal,visited) || jumpRecur(arr,prevVal,visited);
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] visited=new boolean[n];
        return jumpRecur(arr,start,visited);
    }
}