class Solution {
    public double myPow(double x, int n) {
      long N = n;
      if (N < 0) {
        x = 1/x;
        N = -N;
      }
      double res = 1;
      while (N > 0) {
        if (N%2 != 0) 
            res = res*x;
        x = x*x;
        N /= 2;
      }
      return res;
      
    }
}