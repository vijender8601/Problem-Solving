class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        int dp[][] = new int[n+1][n+1];
        for(int i[] : dp)
        Arrays.fill(i,-1);
        return helper(0,-1,words,"",dp);
    }

    private int helper(int i,int prev,String words[],String curr,int dp[][])
    {
        if(i>=words.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int take = 0;
        if(curr.length()==0 || possible(curr,words[i]))
        {
            take = 1+helper(i+1,i,words,words[i],dp);
        }
        int nontake = helper(i+1,prev,words,curr,dp);

        return dp[i][prev+1] = Math.max(take,nontake);
    }

    private boolean possible(String curr,String s)
    {
        int n = s.length(),m = curr.length();
        if(n!=m+1) return false;
        int i=0,j=0,k=0;
        while(i<m && j<n)
        {
            if(curr.charAt(i)==s.charAt(j))
            {
                i++;
                j++;
            } else {
                if(k==1) return false;
                j++;
                k=1;
            }
        }

        return true;
    }
}