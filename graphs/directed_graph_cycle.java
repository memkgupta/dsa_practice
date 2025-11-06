/* Complete the function below */

class Solution {

    // Function to detect a cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V]; // keeps track of visited nodes
        int[] pathVis = new int[V]; // keeps track of nodes currently in the recursion stack (path)

        // I’ll run DFS for every unvisited node
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                // if DFS from this node returns true, means cycle exists
                if (dfs(vis, pathVis, adj, i)) return true;
            }
        }

        // if no DFS call found a cycle, then graph is acyclic
        return false;
    }

    // DFS helper to detect cycle
    public boolean dfs(
        int[] vis,
        int[] pathVis,
        ArrayList<ArrayList<Integer>> adj,
        int node
    ) {
        vis[node] = 1; // mark current node as visited
        pathVis[node] = 1; // mark it as part of the current recursion path

        // explore all neighbours of current node
        for (int e : adj.get(node)) {
            // if neighbour not visited yet, do DFS on it
            if (vis[e] == 0) {
                if (dfs(vis, pathVis, adj, e)) {
                    // if any deeper call detects a cycle, bubble up true
                    return true;
                }
            }
            // if neighbour is already in current recursion path,
            // it means we’ve found a back edge → cycle exists
            else if (pathVis[e] == 1) {
                return true;
            }
        }

        // backtrack step: remove the current node from recursion path
        pathVis[node] = 0;

        // no cycle found from this path
        return false;
    }
}
