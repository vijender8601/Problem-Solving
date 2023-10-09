class Solution {
    public int[] searchRange(int[] a, int target) {
        int n = a.length,i = 0,j = n-1;
        int ans[] = {-1,-1};

        while(i<=j)
        {
            int mid = (i+j)/2;
            if(a[mid]==target)
            {
                ans[0] = mid;
                j = mid-1;
            } else if(a[mid]<target)
            {
                i = mid+1;
            } else j = mid-1;
        }

        i=0;j=n-1;

        while(i<=j)
        {
            int mid = (i+j)/2;
            if(a[mid]==target)
            {
                ans[1] = mid;
                i = mid+1;
            } else if(a[mid]<target)
            {
                i = mid+1;
            } else j = mid-1;
        }


    return ans;
    }
}