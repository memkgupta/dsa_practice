class Solution {

    int maxLength(int arr[]) {
        // code here
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
