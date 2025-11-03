class Solution {

    public int findSubarray(int[] arr) {
        // code here.
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(count, 1);
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (map.containsKey(count)) {
                total += map.get(count);
                map.put(count, map.get(count) + 1);
            } else {
                map.put(count, 1);
            }
        }
        return total;
    }
}
