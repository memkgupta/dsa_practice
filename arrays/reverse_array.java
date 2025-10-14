import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
        int i = m+1; // index from we have to start replacing
        int j = arr.size()-1; // last index
        while(i<j)
        {
            // keep swapping element at index i with element at index j
            int temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,temp);
            i++;
            j--;
        }
        
    }
}
