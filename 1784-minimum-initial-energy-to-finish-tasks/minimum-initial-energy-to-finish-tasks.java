class Solution {
    public int minimumEffort(int[][] tasks) {
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            a.put(i, tasks[i][1] - tasks[i][0]);
        }
        List<Integer> ind = new ArrayList<>(a.keySet());
        Collections.sort(ind, (i, j) -> a.get(j) - a.get(i));
        int energy = 0, curr = 0;
        for (int i = 0; i < ind.size(); i++) {
            int z = ind.get(i);
            int actual = tasks[z][0], minimum = tasks[z][1];
            if (curr < minimum) {
                energy += (minimum - curr);
                curr = minimum;
            }
            curr -= actual;
        }
        return energy;
    }
}