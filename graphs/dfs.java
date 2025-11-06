class Solution {

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(
        int V,
        ArrayList<ArrayList<Integer>> adj
    ) {
        ArrayList<Integer> l = new ArrayList<>(); // this will store the DFS traversal order
        int[] vis = new int[V]; // visited array to keep track of visited nodes

        // I’m starting DFS from node 0 (as the graph is assumed to be connected)
        helper(l, adj, 0, vis);

        // return the final DFS traversal list
        return l;
    }

    // recursive DFS function
    public void helper(
        ArrayList<Integer> list,
        ArrayList<ArrayList<Integer>> adj,
        int e,
        int[] vis
    ) {
        vis[e] = 1; // mark current node as visited
        list.add(e); // add the current node to the traversal list

        // explore all the adjacent nodes
        for (int el : adj.get(e)) {
            // if neighbour node hasn’t been visited, recursively call DFS on it
            if (vis[el] != 1) {
                helper(list, adj, el, vis);
            }
        }
    }
}
