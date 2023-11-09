class Solution {
    public int countHomogenous(String s) {
        long ans = 0,mod = (long)1e9+7;
        int i=0,j=0,n = s.length();
        while(i<n)
        {
            while(j<n && s.charAt(i)==s.charAt(j))
            {
                ans+=(j-i+1);
                j++;
                ans%=mod;
            } 
            i= j;
        }

        return (int)ans;
    }
}