class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length, ans[] = new int[n],x=0;
        
        for(int i=0;i<n;i++)
        {
            ans[i] = pref[i]^x;
            x = x^ans[i];
        }
        
        return ans;
    }
}

// 101
// 010