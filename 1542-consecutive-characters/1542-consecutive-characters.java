class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int i=0,j=0,ans = 1;

        while(i<n)
        {
            while(j<n && s.charAt(i)==s.charAt(j)) j+=1;
            ans = Math.max(j-i,ans);
            i = j;;
        }

        return ans;
    }
}