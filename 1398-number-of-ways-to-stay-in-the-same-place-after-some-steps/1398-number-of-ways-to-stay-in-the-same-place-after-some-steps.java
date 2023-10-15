class Solution {
    long dp[][],mod = (long)1e9+7;
    public int numWays(int steps, int arrLen) {
        dp = new long[steps+1][Math.min(arrLen,steps)+1];

        for(long i[] : dp) Arrays.fill(i,-1);

        return (int)helper(0,steps,arrLen);
    }

    long helper(int i,int steps,int arrLen)
    {
        if(steps==0)
        {
            return (i==0)?1l:0l;
        }

        if(dp[steps][i]!=-1) return dp[steps][i];

        long stay = helper(i,steps-1,arrLen)%mod;
        long right = 0,left = 0;
        if(i+1<arrLen) {
            right = helper(i+1,steps-1,arrLen)%mod;
        }
        if(i-1>=0)
        {
            left = helper(i-1,steps-1,arrLen)%mod;
        }

        return dp[steps][i] = (stay+right+left)%mod;
    }
}