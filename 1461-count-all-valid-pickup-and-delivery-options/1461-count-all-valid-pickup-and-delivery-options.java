class Solution {
    public int countOrders(int n) {
        long dp[] = new long[n+1];
        if(n==1) return n;
        dp[1] = 1l;
        dp[2] = 6l;
        long mod = (long)1e9+7;

        for(int i=3;i<=n;i++)
        {
            long spaces = (2*(i-1));
            long ans = (spaces*(spaces+1)/2)+spaces+1;
            ans%=mod;
            dp[i] = (ans*dp[i-1])%mod;
            // System.out.println(i+" "+spaces+" "+ans+" "+dp[i-1]);
        }

        return (int)dp[n];
    }
}
// _ P1 _ P2 _ D1 _ D2 _

//_ P1 _ D1 _

// _ P1 _ P2 _ P3 _ D1 _ D2 _ D3 _