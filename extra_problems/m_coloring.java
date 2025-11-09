class Solution {

    boolean graphColoring(int v, int[][] edges, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] color = new int[v]; // 0 means uncolored
        return solve(0, adj, color, v, m);
    }

    boolean solve(
        int node,
        ArrayList<ArrayList<Integer>> adj,
        int[] color,
        int v,
        int m
    ) {
        // Base case: all vertices colored
        if (node == v) return true;

        // Try every color for current node
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;

                if (solve(node + 1, adj, color, v, m)) return true;

                color[node] = 0; // backtrack
            }
        }

        return false; // no valid color found
    }

    boolean isSafe(
        int node,
        ArrayList<ArrayList<Integer>> adj,
        int[] color,
        int c
    ) {
        for (int nbr : adj.get(node)) {
            if (color[nbr] == c) return false;
        }
        return true;
    }
}
