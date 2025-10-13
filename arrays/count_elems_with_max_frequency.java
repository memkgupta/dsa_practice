class Solution {
    public int maxFrequencyElements(int[] nums) {
        // 1. brute force 
        /* 
            in brute force we first calculate the frequency of each element
            and keep track of max frequence then traverse over all entries in           map and if the frequency is equal to max_frequency we increase the count 
            T.C = O(2N);
            S.C = O(N); 
        */

       int maxf = -1;
        HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int i : nums)
        {
            fmap.put(i,fmap.getOrDefault(i,0)+1);
            int f = fmap.get(i);
            maxf = Math.max(maxf,f);
        }
        int count = 0;
        for(var e : fmap.entrySet())
        {
            if(e.getValue() == maxf) count+=e.getValue();
        }
        return count; 
     

    /* 
        Optimisation
        we can't optimise it further more hence the brute force will be the optimal solution , instead of using hashmap we may use a simple array of size of constraint in order to save some time consumed in map
     */

    }
}