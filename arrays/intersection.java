class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1)
        {
            set.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums2)
        {
            if(set.contains(i))
            {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int ptr =0;
        for(int i : set2)
        {
            res[ptr++]=i;
        }
        return res;
    }
}