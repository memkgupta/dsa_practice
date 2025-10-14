class Solution {
    public int removeDuplicates(int[] arr) {
        // 'i' will keep track of the position of the last unique element
        int i = 0;

        // Start from the second element (index 1) and move forward
        for (int j = 1; j < arr.length; j++) {

            // If current element arr[j] is not equal to the previous unique element arr[i]
            if (arr[i] != arr[j]) {
                // Move the unique element to the next position (i+1)
                arr[i + 1] = arr[j];

                // Increment 'i' since we found a new unique element
                i++;
            }
        }

        // Return the number of unique elements (i + 1)
        // because 'i' is zero-indexed (if i=0, 1 unique element)
        return i + 1;
    }
}