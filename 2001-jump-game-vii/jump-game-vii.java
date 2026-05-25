class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
      int n=s.length(),farthest=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(q.size()!=0)
        {
            Integer x=q.poll();
            int start=Math.max(x+minJump,farthest+1);
            int end=Math.min(x+maxJump,n-1);
            for(int j=start;j<=end;j++)
                if(s.charAt(j)=='0')
                {
                    if(j==n-1)return true;
                    q.add(j);
                }
            farthest=x+maxJump;
        }
        return false;
    }
}