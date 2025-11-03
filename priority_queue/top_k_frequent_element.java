class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(
            (a, b) -> b.value - a.value
        );

        for (var entry : map.entrySet()) {
            q.add(new Pair(entry.getKey(), entry.getValue()));
            // if(q.size()>k){
            //     q.poll()
            // }
        }
        int i = 0;
        while (!q.isEmpty() && i < k) {
            res[i] = q.poll().key;
            i++;
        }
        return res;
    }
}

class Pair {

    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
