class Solution {
    // Function to solve the Tower of Hanoi problem
    // n    -> number of disks
    // from -> source tower
    // to   -> destination tower
    // aux  -> auxiliary tower
    public int towerOfHanoi(int n, int from, int to, int aux) {
        
        // Base case: If there are no disks to move, no steps are needed
        if (n == 0) {
            return 0;
        }

        int steps = 0;

        // Step 1: Move n-1 disks from 'from' tower to 'aux' tower using 'to' as auxiliary
        steps += towerOfHanoi(n - 1, from, aux, to);

        // Step 2: Move the nth disk from 'from' tower to 'to' tower
        steps += 1; // Count this single move

        // Step 3: Move the n-1 disks from 'aux' tower to 'to' tower using 'from' as auxiliary
        steps += towerOfHanoi(n - 1, aux, to, from);

        // Return the total number of steps taken
        return steps;
    }
}
