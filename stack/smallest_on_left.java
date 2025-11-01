import java.util.*;

class Complete {

    public static int[] Smallestonleft(int arr[], int n) {
        int[] res = new int[n];
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            Integer smaller = set.lower(arr[i]);
            res[i] = (smaller == null) ? -1 : smaller;
            set.add(arr[i]);
        }

        return res;
    }
}
