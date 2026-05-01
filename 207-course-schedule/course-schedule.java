class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int m = prerequisites.length;

        List<List<Integer>> graph = construction(n, m, prerequisites);

        int[] indegree = new int[n];

        for (int u=0; u<n; u++) {
            List<Integer> nbrs = graph.get(u);
            for(int v : nbrs) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()) {
            int rem = q.remove();
            count++;
            List<Integer> nbrs = graph.get(rem);

            for(int v : nbrs) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return count == n;
    }

    static List<List<Integer>> construction(int n, int m, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0 ; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

           
            graph.get(v).add(u); // directed edge
        }

        return graph;
    }


}