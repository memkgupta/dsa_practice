class Solution {

    // Function to return Breadth First Traversal (BFS) of the given graph.
    public ArrayList<Integer> bfsOfGraph(
        int V,
        ArrayList<ArrayList<Integer>> adj
    ) {
        int[] vis = new int[V]; // keeps track of visited nodes
        ArrayList<Integer> res = new ArrayList<>(); // stores the BFS traversal order
        Queue<Integer> q = new ArrayDeque<>(); // standard queue for BFS

        // I’m starting BFS from node 0 (as problem assumes graph is connected)
        q.add(0);
        vis[0] = 1; // mark start node as visited

        // Now, I’ll process nodes level by level
        while (!q.isEmpty()) {
            int e = q.poll(); // pop front element from queue
            res.add(e); // add it to the result (BFS order)

            // loop through all adjacent nodes of the current node
            for (int el : adj.get(e)) {
                // if neighbour is not visited, add it to the queue
                if (vis[el] != 1) {
                    q.add(el);
                    vis[el] = 1; // mark as visited once enqueued
                }
            }
        }

        // after traversal, res contains BFS order
        return res;
    }
}
