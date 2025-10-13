class Solution {
    public int minimumDeletions(int[] nums) {
        // finding minimum and maximum elements indexes using a for loop
        int min_idx = 0;
        int max_idx = 0;
        int n = nums.length;
        for(int i =0;i<n;i++)
        {
            if(min_idx!=-1 && nums[i]<nums[min_idx])
            {
                min_idx = i;
            }
            if(max_idx!=-1 && nums[i]>nums[max_idx])
            {
                max_idx = i;
            }
        }
        
        /*
            Now there can be 5 cases 

            case 1 both minimum and maximum element are same than we will need to return the minimum number of deletions we have to make either from front or back

            case 2 we delete both from front (i.e delete maximum from front and minimum from front) then the total no of deletions we will need will be the deletions made for farthest element from front

            case 3 similiar to case 2 if we delete from back side , i.e farthest from back

            case 4 min is before max and 
                case 4.1 we delete min from front and max from back
                case 4.2 we delete min from back and max from front
            case 5 min is after max
                case 5.1 we delete min from back and max from front
                case 5.2 we delete min from front and max from back 

         */
      
      int min = Integer.MAX_VALUE;
       if(min_idx == max_idx)
       {
        return Math.min(min_idx+1,n-min_idx);
       }
       // case 1 front front
    min = Math.max(min_idx,max_idx)+1;
    // case 2 back back
    min =Math.min(min, Math.max(n-min_idx,n-max_idx));
    
    if(min_idx<max_idx)
    {// case 3.a front back min max
          min = Math.min(min,min_idx+1+n-max_idx);
     // case 3.b back front
        min  = Math.min(min, max_idx-min_idx+n-max_idx);
    }
    if(min_idx>max_idx)
    {
        // case 4.a front back max min
        min = Math.min(min,max_idx+1+n-min_idx);
        // case 4.b back front max min
        min = Math.min(min, min_idx - max_idx + n - min_idx);
    }
    
        return min;
    }
}