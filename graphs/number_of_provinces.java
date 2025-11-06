class Solution {

    int[] vis = new int[201]; // visited array (enough size for constraints)
    int count = 0; // keeps track of number of provinces (connected components)

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // total number of cities

        // iterate through every city
        for (int i = 0; i < n; i++) {
            // if the city is not yet visited -> it's a new province
            if (vis[i] != 1) {
                rec(isConnected, 0, i); // run DFS to mark all connected cities
                count++; // increment province count
            }
        }

        // total number of connected provinces
        return count;
    }

    // recursive DFS function
    void rec(int[][] isConnected, int row, int col) {
        int n = isConnected.length;
        vis[col] = 1; // mark current city as visited

        // check all other cities to see if they are directly connected
        for (int i = 0; i < n; i++) {
            // if city i is connected to 'col' and not visited, continue DFS
            if (isConnected[i][col] == 1 && vis[i] != 1) {
                rec(isConnected, 0, i);
            }
        }
    }
}
