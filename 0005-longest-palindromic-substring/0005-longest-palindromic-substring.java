class Solution {
    public String longestPalindrome(String s) {
        String ans = ""+s.charAt(0);
        
        int n = s.length(),max = 1;
        
        int dp[][] = new int[n][n];
        
        // all string for length 1
        for(int i=0;i<n;i++)dp[i][i] = 1;
        
        // all substrings for length 1
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=1;
                max = 2;
                ans = s.substring(i,i+2);
            }
        }
        
        int len = 2;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j+len<n && s.charAt(j)==s.charAt(j+len) && dp[j+1][j+len-1]==1)
                {
                    dp[j][j+len] = 1;
                    if(len+1>max)
                    {
                        max = len+1;
                        ans = s.substring(j,j+len+1);
                    }
                }
            }
            len++;
        }
        
        
        
        return ans;
    }
}