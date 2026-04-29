class Pair {
    int i;
    int j;
    int t;

    public Pair(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    Pair p = new Pair(i,j,0);
                    q.add(p);
                }else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int ans = -1;

        while(!q.isEmpty()) {
            Pair rem = q.remove();
            int Crow = rem.i;
            int Ccol = rem.j;
            int Ctime = rem.t;

            ans = Ctime;

            // Crow - 1, Ccol -> Up
            if(Crow - 1 >= 0 && grid[Crow-1][Ccol] == 1) {
                Pair p = new Pair(Crow-1,Ccol,Ctime+1);
                q.add(p);
                grid[Crow-1][Ccol] = 2;
            }

            // Crow, Ccol+1 -> Right
            if(Ccol+1 < m && grid[Crow][Ccol+1] == 1) {
                Pair p = new Pair(Crow,Ccol+1,Ctime+1);
                q.add(p);
                grid[Crow][Ccol+1] = 2;
            }

            // Crow+1, Ccol, -> Down
            if(Crow+1 < n && grid[Crow+1][Ccol] == 1) {
                Pair p = new Pair(Crow+1, Ccol, Ctime+1);
                q.add(p);
                grid[Crow+1][Ccol] = 2;
            }

            // Crow, Ccol-1 -> Left
            if(Ccol-1 >= 0 && grid[Crow][Ccol-1] == 1) {
                Pair p = new Pair(Crow, Ccol-1, Ctime+1);
                q.add(p);
                grid[Crow][Ccol-1] = 2;
            }
        }

        if (fresh == 0) return 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}