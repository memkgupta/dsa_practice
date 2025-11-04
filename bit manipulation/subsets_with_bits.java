class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // Total number of subsets for n elements = 2^n
        // Using bitwise left shift for efficiency: (1 << n) == 2^n
        int totalSubsets = 1 << nums.length;

        // This will store all generated subsets
        List<List<Integer>> res = new ArrayList<>();

        // Iterate over all numbers from 0 to (2^n - 1)
        // Each number represents a unique subset (via its binary bits)
        for (int i = 0; i < totalSubsets; i++) {
            // Temporary list to hold the current subset
            List<Integer> list = new ArrayList<>();

            // Check each bit position in 'i'
            for (int j = 0; j < nums.length; j++) {
                // Create a mask for the j-th bit
                int mask = (1 << j);

                // If the j-th bit in i is set (i.e., (mask & i)>0), include nums[j] in the subset
                if ((mask & i) > 0) {
                    list.add(nums[j]);
                }
            }

            // Adding the constructed subset to the main result list
            res.add(list);
        }

        //  final list of all subsets
        return res;
    }
}
