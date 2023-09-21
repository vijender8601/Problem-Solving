class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n = nums1.length,m = nums2.length;
         int temp[] = new int[n+m];
         int i=0,j=0,k=0;

         while(i<n && j<m)
         {
             if(nums1[i]<nums2[j]) temp[k++] = nums1[i++];
             else temp[k++] = nums2[j++];
         }
         while(j<m) temp[k++] = nums2[j++];
         while(i<n) temp[k++] = nums1[i++];

         int l = temp.length;
         double ans = 0;
         if(l%2==1)
         {
             ans = temp[l/2];
         } else {
             ans = (double)(temp[(l/2)]+temp[(l/2)-1])/(double)2;
         }
        return ans;
    }
}
// 1 2 3 4 5 6 7 8
// -1 -2 -3 -4 -5