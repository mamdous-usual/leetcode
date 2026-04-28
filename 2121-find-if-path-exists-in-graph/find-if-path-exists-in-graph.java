class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int m = edges.length;
        List<List<Integer>> graph= construction(n,m,edges);
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(source);
        vis[source] = true;

        while(q.size() > 0) {
            int rem = q.remove();
            List<Integer> nbrs = graph.get(rem);

            for(int v : nbrs) {
                if (vis[v] == false) {
                    q.add(v);
                    vis[v] = true;
                }
            }
        }

        if(vis[destination] == false) return false;
        else return true;
    }

    public List<List<Integer>> construction(int N, int M, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());;
        }

        for(int i=0; i<M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}