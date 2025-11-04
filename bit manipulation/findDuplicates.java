class Solution {

    public int findDuplicate(int[] nums) {
        // First, sort the array using cycle sort logic
        sort(nums);

        // After sorting, ideally each element should be at index = value - 1
        // If not, that means the current element is a duplicate
        for (int i = 0; i < nums.length; i++) {
            // If the number is not in its correct position, it's a duplicate
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }

        // If no duplicate found (shouldn't happen as per problem constraints)
        return -1;
    }

    // Custom sort method using the Cycle Sort pattern
    public void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // The correct index for arr[i] should be arr[i] - 1
            int correctIndex = arr[i] - 1;

            // If the current element is not at its correct position
            // and is different from the element already there → swap it
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                // Otherwise move to the next index
                i++;
            }
        }
    }

    // Utility method to swap two elements in the array
    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
