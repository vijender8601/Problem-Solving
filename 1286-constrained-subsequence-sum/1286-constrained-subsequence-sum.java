class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        seg = new int[4*n];

        build(nums,1,0,n-1);

        int dp[] = new int[n];
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            dp[i] = nums[i];
            if(i>0)
            {
                int val = query(1,0,n-1,Math.max(0,i-k),i-1);
                dp[i] = Math.max(dp[i],dp[i]+val);
            }
            update(1,0,n-1,i,dp[i]);
            res = Math.max(res,dp[i]);
            // System.out.print(dp[i]+" ");
        }

        return res;
    }

    int seg[];

    void build(int nums[],int v,int l,int r)
    {
        if(l==r)
        {
            seg[v] = nums[l];
        } else {
            int m = l+(r-l)/2;
            build(nums,2*v,l,m);
            build(nums,2*v+1,m+1,r);
            seg[v] = Math.max(seg[2*v],seg[2*v+1]);
        }
    }

    int query(int v, int tl, int tr, int l, int r) {
            if (l > r || tr < tl) 
                return Integer.MIN_VALUE;
            if (l == tl && r == tr) {
                return seg[v];
            }
            int tm = (tl + tr) / 2;
            return Math.max(query(v*2, tl, tm, l, Math.min(r, tm)),query(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
        }

        void update(int v, int tl, int tr, int pos, int new_val) {
            if (tl == tr) {
                seg[v] = new_val;
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm)
                    update(v*2, tl, tm, pos, new_val);
                else
                    update(v*2+1, tm+1, tr, pos, new_val);
                seg[v] = Math.max(seg[v*2] , seg[v*2+1]);
            }
        }
}