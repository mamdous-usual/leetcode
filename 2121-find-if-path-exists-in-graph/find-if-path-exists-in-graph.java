class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int m = edges.length;
        List<List<Integer>> graph = construction(n,m,edges);
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(source);
        vis[source] = true;

        while(!q.isEmpty()) {
            int rem = q.remove();

            List<Integer> nbrs = graph.get(rem);

            for (Integer v : nbrs) {
                if(!vis[v]) {
                    q.add(v);
                    vis[v] = true;
                }
            }
        } 


        return vis[destination];
    }

    public List<List<Integer>> construction(int n, int m, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}