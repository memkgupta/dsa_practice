//User function Template for Java

class Solution {

    public static int kthSmallest(int[] arr, int z, int r, int k) {
        int[] heap = new int[arr.length];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }
        for (int l = k - 1; l >= 0; l--) {
            heapify(heap, l);
        }
        for (int i = k; i <= arr.length - 1; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];

                heapify(heap, 0);
            }
            // System.out.println(Arrays.toString(arr));
        }
        // System.out.println(Arrays.toString(arr));

        return heap[0];
    }

    private static void heapify(int[] arr, int index) {
        int smallestIndex = index;
        int lci = index * 2 + 1;
        int rci = index * 2 + 2;
        if (lci < arr.length && arr[smallestIndex] < arr[lci]) {
            smallestIndex = lci;
        }
        if (rci < arr.length && arr[smallestIndex] < arr[rci]) {
            smallestIndex = rci;
        }
        if (smallestIndex == index) {
            return;
        }
        int t = arr[smallestIndex];
        arr[smallestIndex] = arr[index];
        arr[index] = t;
        heapify(arr, smallestIndex);
    }
}
